package p04_recharge_with_adapter;

public abstract class Worker implements Sleeper {

    private String id;
    private int workingHours;

    public Worker(String id) {
        this.id = id;
    }

    public void work(int hours) {
        this.workingHours += hours;
    }
}
