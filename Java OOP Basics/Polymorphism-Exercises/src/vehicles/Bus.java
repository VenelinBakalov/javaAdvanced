package vehicles;

import java.text.DecimalFormat;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public void driveEmpty(double distance) {
        super.drive(distance);
    }

    @Override
    public void drive(double distance) {
        double fuelNeeded = distance * (this.getFuelConsumption() + 1.4);
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        System.out.println(this.getClass().getSimpleName() + " travelled " + new DecimalFormat("0.######").format(distance) + " km");
    }

    @Override
    public void refuel(double fuelAmount) {
        if (this.getFuelQuantity() + fuelAmount > this.getTankCapacity()) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        super.refuel(fuelAmount);
    }
}
