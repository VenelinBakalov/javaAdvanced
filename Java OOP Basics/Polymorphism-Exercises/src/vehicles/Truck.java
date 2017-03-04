package vehicles;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
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
