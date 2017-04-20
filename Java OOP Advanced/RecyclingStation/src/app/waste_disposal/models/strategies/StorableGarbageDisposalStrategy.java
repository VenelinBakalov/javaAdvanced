package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class StorableGarbageDisposalStrategy extends BaseGarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalGarbageVolume = super.getTotalGarbageVolume(garbage);
        super.setEnergyUsed(0.13 * totalGarbageVolume);
        super.setCapitalUsed(0.65 * totalGarbageVolume);

        return super.getProcessingData();
    }
}
