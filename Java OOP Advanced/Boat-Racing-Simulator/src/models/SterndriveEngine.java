package models;

import Utility.Constants;
import Utility.Validator;
import contracts.BoatEngine;
import contracts.IModelable;

public class SterndriveEngine implements IModelable, BoatEngine
{
    private static final int Multiplier = 7;

    public int cachedOutput;

    private String model;

    private int horsepower;

    private int displacement;

    public SterndriveEngine(String model, int horsepower, int displacement)
    {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    public int getOutput() {
        if (this.cachedOutput != 0)
        {
            return this.cachedOutput;
        }

        this.cachedOutput = (this.horsepower * Multiplier) + this.displacement;
        return this.cachedOutput;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
