package p04_recharge_with_adapter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Robot extends Worker {

    private int capacity;
    private int currentPower;

    public Robot(String id, int capacity) {
        super(id);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    public void work(int hours) {
        if (hours > this.currentPower) {
            hours = currentPower;
        }

        super.work(hours);
        this.currentPower -= hours;
    }

    public void recharge() {
        this.currentPower = this.capacity;
    }

    @Override
    public void sleep() {
        throw new NotImplementedException();
    }
}
