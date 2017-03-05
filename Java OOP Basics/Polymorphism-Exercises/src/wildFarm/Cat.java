package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }


    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), this.getBreed(),
                new DecimalFormat("0.######").format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    private String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }
}
