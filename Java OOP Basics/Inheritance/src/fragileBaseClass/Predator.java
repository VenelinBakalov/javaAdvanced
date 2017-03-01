package fragileBaseClass;

import java.util.Collections;

/**
 * Created by Venelin on 1.3.2017 г..
 */
public class Predator extends Animal{

    private int health;

    public void feed(Food food) {
        super.eat(food);
        health++;
    }

    public void feedAll(Food[] foods) {
        Collections.addAll(super.foodEaten, foods);
        health += foods.length;
    }
}
