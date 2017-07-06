package vehiclesExer;

/**
 * Created by Venelin on 6.7.2017 г..
 */
public abstract class VehicleImpl implements Vehicle {

    private Double quantity;
    private Double consumption;

    protected VehicleImpl(Double quantity, Double consumption) {
        this.quantity = quantity;
        this.consumption = consumption;
    }

    @Override
    public void drive(Double km) {
        this.quantity -= km * this.consumption;
    }

    @Override
    public void refuel(Double quantity) {
        this.quantity += quantity;
    }

    @Override
    public boolean canTravel(Double km) {
        return this.quantity / this.consumption >= km;
    }

    @Override
    public Double getQuantity() {
        return this.quantity;
    }

    @Override
    public Double getConsumption() {
        return this.consumption;
    }
}
