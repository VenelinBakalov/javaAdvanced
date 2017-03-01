package fragileBaseClass;

import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 1.3.2017 г..
 */
public class Animal {

    protected List<Food> foodEaten;

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        Collections.addAll(foodEaten, foods);
    }
}
