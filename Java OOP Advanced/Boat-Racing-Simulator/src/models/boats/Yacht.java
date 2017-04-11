package models.boats;

import Utility.Validator;
import contracts.BoatEngine;
import contracts.Race;

/**
 * Created by Venelin on 10.4.2017 г..
 */
public class Yacht extends Boat {

    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine boatEngine, int cargoWeight) {
        super(model, weight);
        this.setBoatEngine(boatEngine);
        this.setCargoWeight(cargoWeight);
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

    @Override
    public double calculateRaceSpeed(Race race) {
        return 0;
    }
}
