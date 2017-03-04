package vehicles;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void refuel(double fuelAmount) {
        if (this.getFuelQuantity() + fuelAmount > this.getTankCapacity()) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        super.refuel(fuelAmount);
    }
}
