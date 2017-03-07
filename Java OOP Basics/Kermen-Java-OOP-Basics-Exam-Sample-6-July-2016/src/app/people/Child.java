package app.people;

import app.items.Toy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Child {

    private List<Toy> toys;
    private double foodCost;
    private double toyCost;

    public Child(double foodCost, List<Toy> toys) {
        this.setFoodCost(foodCost);
        this.toys = toys;
        this.calculateToyCost();
    }

    public double getCost() {
        return this.foodCost + this.toyCost;
    }

    private void calculateToyCost() {
        this.toyCost = this.toys.stream()
                .mapToDouble(Toy::getCost)
                .sum();
    }

    private void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }
}
