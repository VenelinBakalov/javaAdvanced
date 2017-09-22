package models.engines;

import utility.Constants;
import utility.Validator;
import contracts.BoatEngine;

/**
 * Created by Venelin on 11.4.2017 г..
 */
public abstract class BoatEngineImpl implements BoatEngine {

    private String model;
    private int horsepower;
    private int displacement;

    protected BoatEngineImpl(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    final int getHorsepower() {
        return this.horsepower;
    }

    final int getDisplacement() {
        return this.displacement;
    }

    @Override
    public String getModelName() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
