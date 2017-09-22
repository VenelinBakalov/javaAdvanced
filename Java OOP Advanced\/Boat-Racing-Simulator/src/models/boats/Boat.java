package models.boats;

import utility.Constants;
import utility.Validator;
import contracts.Race;
import contracts.Raceable;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public abstract class Boat implements Raceable {

    private String model;
    private int weight;
    private boolean isMotorBoat;
    private double raceTime;

    protected Boat(String model, int weight, boolean isMotorBoat) {
        this.setModel(model);
        this.setWeight(weight);
        this.isMotorBoat = isMotorBoat;
        this.raceTime = 0;
    }

    @Override
    public abstract double calculateRaceSpeed(Race race);

    @Override
    public String getModelName() {
        return this.model;
    }

    @Override
    public void setRaceTime(double raceTime) {
        this.raceTime = raceTime;
    }

    @Override
    public double getRaceTime() {
        return this.raceTime;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isMotorBoat() {
        return this.isMotorBoat;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}
