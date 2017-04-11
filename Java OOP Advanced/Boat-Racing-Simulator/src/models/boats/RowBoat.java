package models.boats;

import Utility.Validator;
import contracts.Race;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return 0;
    }
}
