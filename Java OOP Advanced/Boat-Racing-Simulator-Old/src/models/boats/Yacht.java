package models.boats;

import utility.Validator;
import contracts.BoatEngine;
import contracts.Race;

/**
 * Created by Venelin on 10.4.2017 г..
 */
public class Yacht extends Boat {

    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, boolean isMotorBoat, BoatEngine boatEngine, int cargoWeight) {
        super(model, weight, isMotorBoat);
        this.setBoatEngine(boatEngine);
        this.setCargoWeight(cargoWeight);
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double oceanSpeed = race.getOceanCurrentSpeed() / 2D;
        double result = this.boatEngine.getOutput() - (super.getWeight() + this.cargoWeight) + oceanSpeed;

        return result;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    private void setBoatEngine(BoatEngine boatEngine) {
        if (boatEngine == null) {
            throw new IllegalArgumentException();
        }
        this.boatEngine = boatEngine;
    }
}
