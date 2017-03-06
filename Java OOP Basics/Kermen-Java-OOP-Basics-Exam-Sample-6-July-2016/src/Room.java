/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Room {

    private double electricityCost;
    private int count;

    public Room(double electricityCost, int count) {
        this.setElectricityCost(electricityCost);
        this.setCount(count);
    }

    private void setElectricityCost(double electricityCost) {
        this.electricityCost = electricityCost;
    }

    private void setCount(int count) {
        this.count = count;
    }
}
