package models.boats;

import utility.Validator;
import contracts.Race;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, boolean isMotorBoat, int oars) {
        super(model, weight, isMotorBoat);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double result = (this.oars * 100D) - super.getWeight() + race.getOceanCurrentSpeed();

        return result;
    }
}
