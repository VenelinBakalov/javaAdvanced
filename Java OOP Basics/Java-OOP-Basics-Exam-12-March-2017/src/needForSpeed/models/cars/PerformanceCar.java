package needForSpeed.models.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
        this.calculateHorsepower();
        this.calculateSuspension();
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        super.tune(tuneIndex, addOn);
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Add-ons: %s", getAddons()));
        return sb.toString();
    }

    private void calculateHorsepower() {
        super.setHorsepower(super.getHorsepower() + (super.getHorsepower() * 50) / 100);
    }

    private void calculateSuspension() {
        super.setSuspension(super.getSuspension() - (super.getSuspension() * 25) / 100);
    }

    public String getAddons() {
        if (this.addOns.isEmpty()) {
            return "None";
        }

        return String.join(", ", this.addOns);
    }
}
