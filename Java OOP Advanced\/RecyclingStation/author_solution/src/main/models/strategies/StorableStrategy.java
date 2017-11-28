package main.models.strategies;


import main.models.ProcessingDataImpl;
import main.wasteDisposal.Contracts.GarbageDisposalStrategy;
import main.wasteDisposal.Contracts.ProcessingData;
import main.wasteDisposal.Contracts.Waste;

public class StorableStrategy implements GarbageDisposalStrategy{
    @Override
    public ProcessingData ProcessGarbage(Waste garbage) {
        double spending = (garbage.getWeight() * garbage.getVolumePerKg()) * 0.65;
        double energyCost = (garbage.getWeight() * garbage.getVolumePerKg()) * 0.13;
        return new ProcessingDataImpl(0 - energyCost, 0 - spending);
    }
}
