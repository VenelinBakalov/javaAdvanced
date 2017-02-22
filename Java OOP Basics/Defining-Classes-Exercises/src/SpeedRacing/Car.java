package speedRacing;

public class Car {
    private static final int INITIAL_DISTANCE_TRAVELLED = 0;

    private String model;
    private double fuel;
    private double fuelCostPerKilometer;
    private int distanceTravelled = INITIAL_DISTANCE_TRAVELLED;

    public Car(String model, double fuel, double fuelCostPerKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
    }

    public void drive(int distance) {
        double neededFuel = distance * this.fuelCostPerKilometer;

        if (neededFuel > this.fuel) {
            System.out.println("Insufficient fuel for the drive");
            return;
        }

        this.setFuel(this.getFuel() - neededFuel);
        this.setDistanceTravelled(this.getDistanceTravelled() + distance);
    }

    public String getModel() {
        return model;
    }

    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s", this.model, this.fuel, this.distanceTravelled);
    }
}
