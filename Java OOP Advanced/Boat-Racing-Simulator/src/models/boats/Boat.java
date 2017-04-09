package models.boats;

import Utility.Constants;
import Utility.Validator;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public abstract class Boat {

    private String model;
    private int weight;

    protected Boat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
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
