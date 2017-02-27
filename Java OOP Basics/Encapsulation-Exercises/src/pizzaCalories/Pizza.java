package pizzaCalories;


import java.util.Collections;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public int getNumberOfToppings() {
        return this.getToppings().size();
    }

    public double getTotalCalories() {
        return this.getDough().getCalories() + this.getTotalToppingsCalories();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void addTopping(Topping topping) {
        this.toppings.add(topping);
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
