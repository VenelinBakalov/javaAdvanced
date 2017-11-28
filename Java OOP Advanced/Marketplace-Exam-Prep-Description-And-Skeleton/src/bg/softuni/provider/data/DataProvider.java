package bg.softuni.provider.data;

import bg.softuni.model.product.Product;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public interface DataProvider {

    Product addProduct(int size, String name, String type) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;

    Product getProductById(int id);
}
