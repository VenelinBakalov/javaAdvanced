package models.engines;

import Utility.Constants;
import Utility.Validator;
import contracts.BoatEngine;
import contracts.Modelable;

/**
 * Created by Venelin on 11.4.2017 г..
 */
public abstract class BoatEngineImpl implements BoatEngine {

    private int cachedOutput;
    private String model;
    private int horsepower;
    private int displacement;

    protected BoatEngineImpl(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    protected final int getHorsepower() {
        return horsepower;
    }

    protected final int getDisplacement() {
        return displacement;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }
}
