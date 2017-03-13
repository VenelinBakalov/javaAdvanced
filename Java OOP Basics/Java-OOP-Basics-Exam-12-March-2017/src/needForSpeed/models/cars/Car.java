package needForSpeed.models.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public abstract class Car {
    private static final String DEFAULT_STATUS = "available";
    private static final String PARKED_STATUS = "parked";

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;
    private String status;
    private int performancePoints;
    private List<String> races;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
        this.status = DEFAULT_STATUS;
        this.races = new ArrayList<>();
    }

    public void tune(int tuneIndex, String addOn) {
        this.setHorsepower(this.getHorsepower() + tuneIndex);
        this.setSuspension(this.getSuspension() + (tuneIndex * 50) / 100);
    }

    public void participate(String raceName) {
        this.races.add(raceName);
    }

    public void finishRace(String raceName) {
        this.races.remove(raceName);
    }

    public boolean participatesInRace() {
        return !this.races.isEmpty();
    }

    public int getOverallPerformance() {
        return this.getEnginePerformance() + this.getSuspensionPerformance();
    }

    public int getEnginePerformance() {
        return (this.getHorsepower() / this.acceleration);
    }

    public int getSuspensionPerformance() {
        return (this.getSuspension() + this.durability);
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setParkedStatus() {
        this.status = PARKED_STATUS;
    }

    public void setAvailableStatus() {
        this.status = DEFAULT_STATUS;
    }

    public String getStatus() {
        return status;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getPerformancePoints() {
        return performancePoints;
    }

    public void setPerformancePoints(int performancePoints) {
        this.performancePoints = performancePoints;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d%n", this.brand, this.model, this.yearOfProduction));
        sb.append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), this.acceleration));
        sb.append(String.format("%d Suspension force, %d Durability%n", this.getSuspension(), this.durability));
        return sb.toString();
    }



    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }
}
