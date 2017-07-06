package vehiclesExer;

/**
 * Created by Venelin on 6.7.2017 г..
 */
public class Truck extends VehicleImpl {

    public Truck(Double quantity, Double consumption) {
        super(quantity, consumption + 1.6);
    }

    @Override
    public void refuel(Double quantity) {
        super.refuel(quantity * 0.95);
    }
}
