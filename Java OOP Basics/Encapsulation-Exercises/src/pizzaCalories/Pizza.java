package pizzaCalories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name) {
        this.setName(name);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfToppings() {
        int toppings = this.getToppings().size();
        if (10 < toppings) {
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }
        return toppings;
    }

    public double getTotalCalories() {
        return this.getDough().getCalories() + this.getTotalToppingsCalories();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getTotalCalories());
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private double getTotalToppingsCalories() {
        return getToppings().stream().mapToDouble(Topping::getCalories).sum();
    }

    private List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    private Dough getDough() {
        return dough;
    }
}
