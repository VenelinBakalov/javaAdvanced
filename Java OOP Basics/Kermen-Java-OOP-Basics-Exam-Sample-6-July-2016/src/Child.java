import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Child {

    private double foodCost;
    private List<Toy> toys;

    public Child(double foodCost) {
        this.setFoodCost(foodCost);
        this.toys = new ArrayList<>();
    }

    private void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }
}
