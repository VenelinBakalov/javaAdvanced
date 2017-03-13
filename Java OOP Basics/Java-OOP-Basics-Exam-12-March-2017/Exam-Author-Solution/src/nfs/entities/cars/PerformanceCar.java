package nfs.entities.cars;

import nfs.utilities.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.modifyStats();
        this.addOns = new ArrayList<String>();
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }

    private void modifyStats() {
        this.setHorsepower(this.getHorsepower() + (this.getHorsepower() * Constants.PERFORMANCE_CAR_HORSEPOWER_PERCENTAGE_MODIFIER) / Constants.MAXIMUM_PERCENTAGE);
        this.setSuspension(this.getSuspension() - (this.getSuspension() * Constants.PERFORMANCE_CAR_SUSPENSION_PERCENTAGE_MODIFIER) / Constants.MAXIMUM_PERCENTAGE);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);

        this.addOns.add(tuneAddOn);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        result.append(String.format("Add-ons: %s", this.getAddOns().size() > 0 ? String.join(", ", this.getAddOns()) : "None"));

        return result.toString();
    }
}
