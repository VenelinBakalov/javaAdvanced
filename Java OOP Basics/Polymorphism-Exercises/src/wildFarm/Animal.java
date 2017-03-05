package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
        this.setFoodEaten(0);
    }

    abstract void makeSound();
    abstract void eat(Food food);

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected Double getAnimalWeight() {
        return this.animalWeight;
    }

    protected String getAnimalType() {
        return animalType;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

}
