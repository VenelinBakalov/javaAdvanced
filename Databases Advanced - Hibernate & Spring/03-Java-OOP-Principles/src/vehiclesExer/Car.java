package vehiclesExer;

/**
 * Created by Venelin on 6.7.2017 г..
 */
public class Car extends VehicleImpl {

    public Car(Double quantity, Double consumption) {
        super(quantity, consumption + 0.9);
    }
}
