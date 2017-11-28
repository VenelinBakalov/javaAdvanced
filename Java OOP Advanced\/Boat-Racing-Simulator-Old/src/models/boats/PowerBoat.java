package models.boats;

import contracts.BoatEngine;
import contracts.Race;

/**
 * Created by Venelin on 10.4.2017 г..
 */
public class PowerBoat extends Boat {

    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, boolean isMotorBoat, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight, isMotorBoat);
        this.setFirstEngine(firstEngine);
        this.setSecondEngine(secondEngine);
    }

    private void setFirstEngine(BoatEngine firstEngine) {
        if (firstEngine == null) {
            throw new IllegalArgumentException();
        }
        this.firstEngine = firstEngine;
    }

    private void setSecondEngine(BoatEngine secondEngine) {
        if (secondEngine == null) {
            throw new IllegalArgumentException();
        }
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double engineSum = (this.firstEngine.getOutput() + this.secondEngine.getOutput() * 1.0);
        double oceanSpeed = race.getOceanCurrentSpeed() / 5D;
        double result = (engineSum - super.getWeight() + oceanSpeed);

        return result;
    }
}
