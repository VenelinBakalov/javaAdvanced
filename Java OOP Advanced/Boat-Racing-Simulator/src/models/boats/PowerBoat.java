package models.boats;

import contracts.BoatEngine;

/**
 * Created by Venelin on 10.4.2017 г..
 */
public class PowerBoat extends Boat {

    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
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
}
