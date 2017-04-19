package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Venelin on 19.4.2017 г..
 */
public class RecyclableGarbageDisposalStrategy extends BaseGarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double totalGarbageVolume = super.getTotalGarbadgeVolume(garbage);
        super.setEnergyUsed(0.5 * totalGarbageVolume);
        super.setCapitalEarned(400 * garbage.getWeight());

        return super.getProcessingData();
    }
}
