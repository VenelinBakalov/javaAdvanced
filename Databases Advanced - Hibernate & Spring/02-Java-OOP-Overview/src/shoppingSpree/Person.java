package shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Person {

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.getMoney() >= product.getCost()) {
            this.setMoney(this.getMoney() - product.getCost());
            this.bagOfProducts.add(product);
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        if (this.getBagOfProducts().size() == 0) {
            return this.getName() + " - Nothing bought";
        }

        return this.getName() + " - " + String.join(", ", this.getBagOfProducts().stream().map(Object::toString).collect(Collectors.toList()));
    }

    public String getName() {
        return name;
    }

    public List<Product> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    private double getMoney() {
        return money;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }
}
