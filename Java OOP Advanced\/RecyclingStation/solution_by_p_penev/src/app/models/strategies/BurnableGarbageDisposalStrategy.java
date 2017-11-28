package app.models.strategies;

import app.models.WasteData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class BurnableGarbageDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double volume = garbage.getVolumePerKg() * garbage.getWeight();
        double energyBalance = volume * 0.8;
        double capitalBalance = 0.0;

        return new WasteData(energyBalance, capitalBalance);
    }
}
