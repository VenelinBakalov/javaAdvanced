package models.boats;

import Utility.Constants;

/**
 * Created by Venelin on 10.4.2017 г..
 */
public class SailBoat extends Boat {

    private static final int MINIMUM_SAIL_EFFICIENCY = 1;
    private static final int MAXIMUM_SAIL_EFFICIENCY = 100;

    private int sailEfficiency;


    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < MINIMUM_SAIL_EFFICIENCY || sailEfficiency > MAXIMUM_SAIL_EFFICIENCY) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIANCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }
}
