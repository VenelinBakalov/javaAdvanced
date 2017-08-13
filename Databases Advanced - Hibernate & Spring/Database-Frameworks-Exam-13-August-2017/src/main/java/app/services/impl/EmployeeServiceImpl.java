package app.services.impl;

import app.constants.ResultMessages;
import app.dto.employees.EmployeeImportXmlDto;
import app.entities.Branch;
import app.entities.Employee;
import app.entities.EmployeeCard;
import app.repositories.BranchRepository;
import app.repositories.EmployeeCardRepository;
import app.repositories.EmployeeRepository;
import app.services.api.EmployeeService;
import app.utils.DTOConverter;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCardRepository employeeCardRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public String add(EmployeeImportXmlDto employeeImportXmlDto) {

        Employee employee = DTOConverter.convert(employeeImportXmlDto, Employee.class);
        EmployeeCard card = this.employeeCardRepository.findByNumber(employeeImportXmlDto.getCard());
        Branch branch = this.branchRepository.findByName(employeeImportXmlDto.getBranch());

        employee.setCard(card);
        employee.setBranch(branch);

        String result;
        if (DataValidator.isValid(employee) && ! employeeWithDuplicateCardExists(employee)) {
            this.employeeRepository.save(employee);
            result = String.format(ResultMessages.SUCCESSFUL,
                    employee.getClass().getSimpleName(),
                    employee);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public List<Employee> findAllProductiveEmployees() {
        return this.employeeRepository.findAllProductiveEmployees()
                .stream()
                .sorted((e1, e2) -> {
            int result = (e1.getFirstName() + " " + e1.getLastName()).compareTo(e2.getFirstName() + " " + e2.getLastName());

            if (result == 0) {
                result = Integer.compare(e2.getPosition().length(), e1.getPosition().length());
            }
            return result;
                })
                .collect(Collectors.toList());
    }

    private boolean employeeWithDuplicateCardExists(Employee employee) {
        Employee duplicate = this.employeeRepository.findByCard(employee.getCard());
        return duplicate != null;
    }
}
