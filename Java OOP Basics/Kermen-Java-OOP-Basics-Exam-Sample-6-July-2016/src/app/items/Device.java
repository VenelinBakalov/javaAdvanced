package app.items;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Device {

    private double consumption;

    public Device(double consumption) {
        this.setConsumption(consumption);
    }

    public double getConsumption() {
        return consumption;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
