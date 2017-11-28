package tests.fakes;

import app.waste_disposal.contracts.Waste;

/**
 * Created by Venelin on 21.4.2017 г..
 */

public class NonDisposableWaste implements Waste {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getVolumePerKg() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
