package main.models.strategies;


import main.models.ProcessingDataImpl;
import main.wasteDisposal.Contracts.GarbageDisposalStrategy;
import main.wasteDisposal.Contracts.ProcessingData;
import main.wasteDisposal.Contracts.Waste;

public class RecyclableStrategy implements GarbageDisposalStrategy{
    @Override
    public ProcessingData ProcessGarbage(Waste garbage) {
        double usedEnergy = (garbage.getWeight() * garbage.getVolumePerKg()) / 2;
        double income = garbage.getWeight() * 400;
        return new ProcessingDataImpl(0 - usedEnergy, income);
    }
}
