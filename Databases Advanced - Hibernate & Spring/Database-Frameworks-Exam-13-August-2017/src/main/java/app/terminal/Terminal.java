package app.terminal;

import app.dto.branches.BranchExportXmlDto;
import app.dto.branches.BranchImportJsonDto;
import app.dto.branches.BranchWrapperExportXmlDto;
import app.dto.employeeCards.EmployeeCardExportJsonDto;
import app.dto.employeeCards.EmployeeCardImportJsonDto;
import app.dto.employees.EmployeeExportJsonDto;
import app.dto.employees.EmployeeImportXmlDto;
import app.dto.employees.EmployeesWrapperImportXmlDto;
import app.dto.products.ProductImportXmlDto;
import app.dto.products.ProductsWrapperImportXmlDto;
import app.dto.towns.TownExportXmlDto;
import app.dto.towns.TownImportJsonDto;
import app.dto.towns.TownsWrapperExportXmlDto;
import app.entities.*;
import app.io.ConsoleWriter;
import app.serialize.api.Serializer;
import app.services.api.*;
import app.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static app.constants.Paths.*;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private ConsoleWriter consoleWriter;

    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    @Autowired
    private TownService townService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private EmployeeCardService employeeCardService;

    @Autowired
    private ProductService productService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... strings) throws Exception {

        /*
        IMPORTS
         */

        importTownsJson();
        importBranchesJson();
        importEmployeeCardsJson();

        importProductsXml();
        importEmployeesXml();

        /*
        EXPORTS
         */

        exportUnusedCardsJson();
        exportProductiveEmployees();

        exportTownsByClients();
        exportBranches();
    }

    private void exportBranches() {
        List<Branch> branches = this.branchService.findAll();
        List<BranchExportXmlDto> branchExportXmlDtos = new ArrayList<>();

        for (Branch branch : branches) {
            BranchExportXmlDto branchExportXmlDto = DTOConverter.convert(branch, BranchExportXmlDto.class);
            int branchClients = this.productService.findByBranch(branch)
                    .stream()
                    .mapToInt(Product::getClients)
                    .sum();

            branchExportXmlDto.setTotalClients(branchClients);

            branchExportXmlDtos.add(branchExportXmlDto);
        }

        BranchWrapperExportXmlDto wrapper = new BranchWrapperExportXmlDto();
        wrapper.setBranches(branchExportXmlDtos
                .stream()
                .sorted((b1, b2) -> Integer.compare(b2.getTotalClients(), b1.getTotalClients()))
                .collect(Collectors.toList()));

        this.xmlSerializer.serialize(wrapper, BRANCHES_OUTPUT_XML);
    }

    private void exportTownsByClients() {
        List<Town> towns = this.townService.findAll();
        List<TownExportXmlDto> townExportXmlDtos = new ArrayList<>();

        for (Town town : towns) {
            TownExportXmlDto townExportXmlDto = DTOConverter.convert(town, TownExportXmlDto.class);

            int townClients = 0;
            List<Branch> branchesByTown = this.branchService.findByTownName(town.getName());
            for (Branch branch : branchesByTown) {
                List<Product> products = this.productService.findByBranch(branch);
                townClients += products
                        .stream()
                        .mapToInt(Product::getClients)
                        .sum();
            }

            townExportXmlDto.setTownClients(townClients);
            townExportXmlDtos.add(townExportXmlDto);
        }

        townExportXmlDtos = townExportXmlDtos
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getTownClients(), t1.getTownClients()))
                .collect(Collectors.toList());

        TownsWrapperExportXmlDto townsWrapperExportXmlDto = new TownsWrapperExportXmlDto();
        townsWrapperExportXmlDto.setTowns(townExportXmlDtos);

        this.xmlSerializer.serialize(townsWrapperExportXmlDto, TOWNS_BY_CLIENTS_OUTPUT_XML);
    }

    private void exportProductiveEmployees() {
        List<Employee> productiveEmployees = this.employeeService.findAllProductiveEmployees();
        List<EmployeeExportJsonDto> employeeExportJsonDtos = new ArrayList<>();

        for (Employee productiveEmployee : productiveEmployees) {
            EmployeeExportJsonDto employeeExportJsonDto = DTOConverter.convert(productiveEmployee, EmployeeExportJsonDto.class);
            employeeExportJsonDto.setFullName(String.format("%s %s",
                    productiveEmployee.getFirstName(),
                    productiveEmployee.getLastName()));
            employeeExportJsonDtos.add(employeeExportJsonDto);
        }
        this.jsonSerializer.serialize(employeeExportJsonDtos, PRODUCTIVE_EMPLOYEES_OUTPUT_JSON);
    }

    private void exportUnusedCardsJson() {
        List<EmployeeCard> unusedCards = this.employeeCardService.findAllUnusedCards();
        List<EmployeeCardExportJsonDto> employeeCardExportJsonDtos = DTOConverter.convert(unusedCards, EmployeeCardExportJsonDto.class);

        this.jsonSerializer.serialize(employeeCardExportJsonDtos, UNUSED_CARDS_OUTPUT_JSON);
    }

    private void importEmployeesXml() {
        EmployeesWrapperImportXmlDto employeeWrapperDto = this.xmlSerializer.deserialize(EmployeesWrapperImportXmlDto.class, EMPLOYEES_INPUT_XML);
        for (EmployeeImportXmlDto employeeImportXmlDto : employeeWrapperDto.getEmployees()) {
            String result = this.employeeService.add(employeeImportXmlDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importProductsXml() {
        ProductsWrapperImportXmlDto productsWrapperDto = this.xmlSerializer.deserialize(ProductsWrapperImportXmlDto.class, PRODUCTS_INPUT_XML);
        for (ProductImportXmlDto productImportXmlDto : productsWrapperDto.getProducts()) {
            String result = this.productService.add(productImportXmlDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importEmployeeCardsJson() {
        EmployeeCardImportJsonDto[] employeeCardDtos = this.jsonSerializer.deserialize(EmployeeCardImportJsonDto[].class, EMPLOYEE_CARDS_INPUT_JSON);
        for (EmployeeCardImportJsonDto employeeCardDto : employeeCardDtos) {
            EmployeeCard employeeCard = DTOConverter.convert(employeeCardDto, EmployeeCard.class);
            String result = this.employeeCardService.add(employeeCard);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importBranchesJson() {
        BranchImportJsonDto[] branchDtos = this.jsonSerializer.deserialize(BranchImportJsonDto[].class, BRANCHES_INPUT_JSON);
        for (BranchImportJsonDto branchDto : branchDtos) {
            String result = this.branchService.add(branchDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importTownsJson() {
        TownImportJsonDto[] townDtos = this.jsonSerializer.deserialize(TownImportJsonDto[].class, TOWNS_INPUT_JSON);
        for (TownImportJsonDto townDto : townDtos) {
            Town town = DTOConverter.convert(townDto, Town.class);
            String result = this.townService.add(town);
            this.consoleWriter.writeLine(result);
        }
    }

}
