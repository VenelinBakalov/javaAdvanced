package wildFarm;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
