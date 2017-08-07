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
import products_shop.app.dto.view.*;
import products_shop.app.services.CategoryService;
import products_shop.app.services.ProductService;
import products_shop.app.services.UserService;
import products_shop.app.utils.io.JsonParser;
import products_shop.app.utils.io.XMLParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;



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

    @Override
    public void run(String... strings) throws Exception {


//        importUsersFromXML();
//        importCategoriesFromXml();
        importProductsFromXml();
    }


    private void export4() {
        String path = "/src/main/resources/files/out/users-and-products.json";
        UserDtoViewWrapper info = this.userService.findAllUserByAtLeastOneSell();

        try {
            this.jsonParser.writeObject(info,path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private void export3() {
        String path = "/src/main/resources/files/out/categories-by-products.json";

        List<CategoryDtoView> categories=this.categoryService.findAllOrderedByProductCount();

        try {
            this.jsonParser.writeObject(categories,path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void export2() {
        String path = "/src/main/resources/files/out/users-sold-products.json";

        List<UserDtoViewSold> usersWithSoldProducts = this.userService.findUsersWithSoldProducts();

        try {
            this.jsonParser.writeObject(usersWithSoldProducts, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void export1() {
        String path = "/src/main/resources/files/out/products-in-range.json";
        List<ProductDtoView> productsByPrice =
                this.productService.findProductsByPrice(new BigDecimal("500"), new BigDecimal("1000"));

        try {
            this.jsonParser.writeObject(productsByPrice, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void seedDB() {
        importUsers();
        importCategories();
        importProducts();

    }

    private void importProducts() {
        String path = "/files/json/in/products.json";
        Random random = new Random();
        List<UserDto> allUsers = this.userService.findAll();
        List<CategoryDto> allCategories = this.categoryService.findAll();
        try {
            ProductAddDto[] products = this.jsonParser.getObject(ProductAddDto[].class, path);
            for (ProductAddDto product : products) {

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
        }

    }

    private void importCategories() {
        String path = "/files/json/in/categories.json";
        try {
            CategoryAddDto[] categories = this.jsonParser.getObject(CategoryAddDto[].class, path);
            for (CategoryAddDto category : categories) {
                this.categoryService.register(category);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void importUsers() {
        String path = "/files/json/in/users.json";
        try {
            UserAddDto[] users = this.jsonParser.getObject(UserAddDto[].class, path);
            for (UserAddDto user : users) {
                this.userService.registerUser(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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

    }
}
