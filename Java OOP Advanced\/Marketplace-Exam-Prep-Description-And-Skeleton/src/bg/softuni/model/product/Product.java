package bg.softuni.model.product;

import bg.softuni.model.shop.Shop;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public interface Product {

    int getSize();

    String getName();

    Shop getShop();

    int getId();

    void setSize(int size);

    void setName(String name);

    void setShop(Shop shop);

}
