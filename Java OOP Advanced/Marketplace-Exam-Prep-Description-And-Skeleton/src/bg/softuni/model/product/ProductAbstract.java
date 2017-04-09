package bg.softuni.model.product;

import bg.softuni.constants.Messages;
import bg.softuni.model.shop.Shop;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public abstract class ProductAbstract implements Product {

    private int id;
    private int size;
    private String name;
    private Shop shop;

    public ProductAbstract(int id, int size, String name) {
        this.setId(id);
        this.setSize(size);
        this.setName(name);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Shop getShop() {
        return shop;
    }

    @Override
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                Messages.PRODUCT_TO_STRING,
                this.getClass().getSimpleName(),
                this.getId(),
                this.getSize(),
                this.getName()
        );
    }
}
