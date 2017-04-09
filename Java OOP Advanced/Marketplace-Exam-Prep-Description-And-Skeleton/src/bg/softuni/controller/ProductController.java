package bg.softuni.controller;

import bg.softuni.constants.Messages;
import bg.softuni.framework.lifecycle.RequestMapping;
import bg.softuni.framework.lifecycle.component.Inject;
import bg.softuni.framework.lifecycle.controller.UriParameter;
import bg.softuni.framework.lifecycle.request.RequestMethod;
import bg.softuni.model.product.Product;
import bg.softuni.provider.data.DataProvider;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class ProductController {

    @Inject
    private DataProvider db;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getById(@UriParameter("id") int id) {
        Product product = this.db.getProductById(id);
        if (product == null) {
            return String.format(
                    Messages.PRODUCT_DOES_NOT_EXIST,
                    id
            );
        }

        return product.toString();
    }

    @RequestMapping(value = "/product/{size}/{name}/{type}", method = RequestMethod.ADD)
    public String addProduct(@UriParameter("size") int size, @UriParameter("name") String name, @UriParameter("type") String type) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Product addedProduct = this.db.addProduct(size, name, type);

        return String.format(
                Messages.PRODUCT_REGISTERED_OK,
                addedProduct.getId());
    }
}
