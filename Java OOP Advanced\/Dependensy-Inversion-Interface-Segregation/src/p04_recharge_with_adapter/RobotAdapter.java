package p04_recharge_with_adapter;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public class RobotAdapter implements Rechargeable {

    private Robot robot;
    private int currentPower;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void recharge() {
        this.currentPower += 123;
    }
}
