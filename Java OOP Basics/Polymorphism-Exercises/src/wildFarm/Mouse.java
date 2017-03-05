package wildFarm;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public class Mouse extends Mammal {


    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }
        if (food.getQuantity() == 0) {
            throw new IllegalArgumentException("A cheese was just eaten!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
