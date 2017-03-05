package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by Venelin on 5.3.2017 г..
 */
public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(),
                new DecimalFormat("0.######").format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}
