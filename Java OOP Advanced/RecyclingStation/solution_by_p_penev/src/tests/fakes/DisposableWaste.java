package tests.fakes;

import app.waste_disposal.contracts.Waste;

@DisposableAnnotation
public class DisposableWaste implements Waste {

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
