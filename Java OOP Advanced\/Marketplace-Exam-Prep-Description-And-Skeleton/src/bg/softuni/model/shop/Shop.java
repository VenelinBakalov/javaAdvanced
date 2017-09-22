package bg.softuni.model.shop;

import bg.softuni.model.product.Product;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public interface Shop<S> {

    Iterable<Product> getProducts();

    Shop addProduct(Product product);
}
