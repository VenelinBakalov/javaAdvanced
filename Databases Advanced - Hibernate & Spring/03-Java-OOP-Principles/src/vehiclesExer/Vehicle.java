package vehiclesExer;

/**
 * Created by Venelin on 6.7.2017 г..
 */
public interface Vehicle {
    void drive(Double km);
    void refuel(Double quantity);
    boolean canTravel(Double km);
    Double getQuantity();
    Double getConsumption();
}
