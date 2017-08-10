package products_shop.app.Terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import products_shop.app.dto.bind.add.CategoryAddDto;
import products_shop.app.dto.bind.add.ProductAddDto;
import products_shop.app.dto.bind.add.UserAddDto;
import products_shop.app.dto.bind.xmlDtos.CategoriesImportXmlDto;
import products_shop.app.dto.bind.xmlDtos.ProductsImportXMLDto;
import products_shop.app.dto.bind.xmlDtos.UsersImportXMLDto;
import products_shop.app.dto.view.CategoryDto;
import products_shop.app.dto.view.ProductViewDto;
import products_shop.app.dto.view.UserDto;
import products_shop.app.dto.view.xml.ProductsExportXMLDto;
import products_shop.app.services.CategoryService;
import products_shop.app.services.ProductService;
import products_shop.app.services.UserService;
import products_shop.app.utils.io.JsonParser;
import products_shop.app.utils.io.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

/**
 * This time this is not exactly created by Venelin :D Keep reading the comment above the run() method and you will know
 * what I mean :)
 */

@Component
public class Ternimal implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    private final JsonParser jsonParser;

    private final XMLParser xmlParser;

    @Autowired
    public Ternimal(UserService userService, ProductService productService, CategoryService categoryService, JsonParser jsonParser, XMLParser xmlParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    // Well it's quite a sloppy homework..it is far from complete and I even used a project skeleton from the previous
    // homework from another person since I was outside Sofia and couldn't do it...so sorry for the lame homework, normally
    // I like to do stuff perfect but this time I had to choose between this and the exam preparation and guess what...
    // the homework lost :D so don't waste much of your time checking it - I've done only the 4 methods in the run() method.
    // The work well, nothing else does :D
    @Override
    public void run(String... strings) throws Exception {

        importUsersFromXML();
        importCategoriesFromXml();
        importProductsFromXml();
        exportToXml();
    }


    private void importUsersFromXML() {
        UsersImportXMLDto users = null;
        try {
            users = this.xmlParser.getObject(UsersImportXMLDto.class, "/files/xml/in/users.xml");
            for (UserAddDto user : users.getUserAddDtos()) {
                this.userService.registerUser(user);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importCategoriesFromXml() {
        try {
            CategoriesImportXmlDto categories = this.xmlParser.getObject(CategoriesImportXmlDto.class, "/files/xml/in/categories.xml");
            for (CategoryAddDto categoryAddDto : categories.getCategoryAddDtos()) {
                this.categoryService.register(categoryAddDto);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importProductsFromXml() {
        String path = "/files/xml/in/products.xml";
        Random random = new Random();
        List<UserDto> allUsers = this.userService.findAll();
        List<CategoryDto> allCategories = this.categoryService.findAll();
        try {
            ProductsImportXMLDto products = this.xmlParser.getObject(ProductsImportXMLDto.class, path);
            for (ProductAddDto product : products.getProductAddDtos()) {

                Set<CategoryDto> categories = new HashSet<>();
                int categoryNumber = random.nextInt(allCategories.size());
                for (int i = 0; i < categoryNumber; i++) {
                    CategoryDto categoryDto = allCategories.get(random.nextInt(allCategories.size()));

                    categories.add(categoryDto);
                }

                product.setCategories(categories);

                UserDto userSeller = allUsers.get(random.nextInt(allUsers.size()));
                product.setSeller(userSeller);

                int i = random.nextInt(allUsers.size());
                UserDto userBuyer = allUsers.get(i);
                if (i % 7 == 0) {
                    product.setBuyer(userBuyer);
                }

                this.productService.register(product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportToXml() {
        ProductsExportXMLDto productsExportXMLDto = this.productService.getProductsToExport();
        for (ProductViewDto productViewDto : productsExportXMLDto.getProductViewDtos()) {
            productViewDto.setDate(new Date());
        }
        try {
            this.xmlParser.writeObject(productsExportXMLDto, "src/main/resources/files/xml/out/productsExampleDate.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
