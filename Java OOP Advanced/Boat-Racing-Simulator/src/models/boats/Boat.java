package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.Modelable;
import contracts.Race;
import contracts.Raceable;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public abstract class Boat implements Raceable {

    private String model;
    private int weight;

    protected Boat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    public abstract double calculateRaceSpeed(Race race);

    @Override
    public String getModelName() {
        return this.model;
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
