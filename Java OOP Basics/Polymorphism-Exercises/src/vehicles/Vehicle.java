package vehicles;

import java.text.DecimalFormat;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

    public void drive(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be non-negative");
        }
        double fuelNeeded = distance * this.getFuelConsumption();
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        System.out.println(this.getClass().getSimpleName() + " travelled " + new DecimalFormat("###.#").format(distance) + " km");
    }

    public void refuel(double fuelAmount) {
        if (fuelAmount < 0) {
            throw new IllegalArgumentException("Fuel amount must be non-negative");
        }
        this.setFuelQuantity(this.getFuelQuantity() + fuelAmount);
    }

    protected void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption <= 0) {
            throw new IllegalArgumentException("Fuel consumption must be positive");
        }
        this.fuelConsumption = fuelConsumption;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel quantity must be non-negative");
        }
        this.fuelQuantity = fuelQuantity;
    }

    private double getFuelQuantity() {
        return fuelQuantity;
    }

    private double getFuelConsumption() {
        return fuelConsumption;
    }
}
