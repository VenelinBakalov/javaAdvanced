package wildFarm;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
