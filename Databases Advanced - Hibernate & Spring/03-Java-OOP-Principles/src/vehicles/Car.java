package vehicles;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void refuel(double fuelAmount) {
        super.refuel(fuelAmount);
    }
}
