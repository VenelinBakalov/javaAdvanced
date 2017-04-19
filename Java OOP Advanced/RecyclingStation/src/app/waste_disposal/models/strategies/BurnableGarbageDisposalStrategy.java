package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class BurnableGarbageDisposalStrategy extends BaseGarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalGarbageVolume = super.getTotalGarbadgeVolume(garbage);
        super.setEnergyProduced(totalGarbageVolume);
        super.setEnergyUsed(0.20 * totalGarbageVolume);

        return super.getProcessingData();
    }
}
