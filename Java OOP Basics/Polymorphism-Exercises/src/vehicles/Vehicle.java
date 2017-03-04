package vehicles;

import java.text.DecimalFormat;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

    public void drive(double distance) {
        double fuelNeeded = distance * this.getFuelConsumption();
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        System.out.println(this.getClass().getSimpleName() + " travelled " + new DecimalFormat("0.######").format(distance) + " km");
    }

    public void refuel(double fuelAmount) {
        this.setFuelQuantity(this.getFuelQuantity() + fuelAmount);
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }
}
