package models.boats;

import utility.Constants;
import contracts.Race;

/**
 * Created by Venelin on 10.4.2017 г..
 */
public class SailBoat extends Boat {

    private static final int MINIMUM_SAIL_EFFICIENCY = 1;
    private static final int MAXIMUM_SAIL_EFFICIENCY = 100;

    private int sailEfficiency;


    public SailBoat(String model, int weight, boolean isMotorBoat, int sailEfficiency) {
        super(model, weight, isMotorBoat);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < MINIMUM_SAIL_EFFICIENCY || sailEfficiency > MAXIMUM_SAIL_EFFICIENCY) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double boatEfficiency = race.getWindSpeed() * (this.sailEfficiency / 100D);
        double oceanSpeed = race.getOceanCurrentSpeed() / 2D;
        double result = boatEfficiency - super.getWeight() + oceanSpeed;

        return result;
    }
}
