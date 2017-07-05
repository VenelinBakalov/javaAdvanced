package vehicles;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public void refuel(double fuelAmount) {
        super.refuel(0.95 * fuelAmount);
    }
}
