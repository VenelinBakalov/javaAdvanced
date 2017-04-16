package main.models.strategies;


import main.models.ProcessingDataImpl;
import main.wasteDisposal.Contracts.GarbageDisposalStrategy;
import main.wasteDisposal.Contracts.ProcessingData;
import main.wasteDisposal.Contracts.Waste;

public class BurnableStrategy implements GarbageDisposalStrategy{
    @Override
    public ProcessingData ProcessGarbage(Waste garbage) {
        double energyGained = (garbage.getWeight() * garbage.getVolumePerKg()) * 0.8;
        return new ProcessingDataImpl(energyGained, 0);
    }
}
