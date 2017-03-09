package app;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Room {

    private double consumption;

    public Room(double consumption) {
        this.setConsumption(consumption);
    }

    public double getConsumption() {
        return consumption;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption;
    }

}
