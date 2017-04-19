package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.data.ProcessingDataImpl;

/**
 * Created by Venelin on 19.4.2017 г..
 */
public abstract class BaseGarbageDisposalStrategy implements GarbageDisposalStrategy {

    private double energyProduced;
    private double energyUsed;
    private double capitalEarned;
    private double capitalUsed;

    protected double getTotalGarbadgeVolume(Waste garbage) {
        return garbage.getWeight() * garbage.getVolumePerKg();
    }

    protected ProcessingData getProcessingData() {
        return new ProcessingDataImpl(this.getEnergyBalance(), this.getCapitalBalance());
    }

    protected void setEnergyProduced(double energyProduced) {
        this.energyProduced = energyProduced;
    }

    protected void setEnergyUsed(double energyUsed) {
        this.energyUsed = energyUsed;
    }

    protected void setCapitalEarned(double capitalEarned) {
        this.capitalEarned = capitalEarned;
    }

    protected void setCapitalUsed(double capitalUsed) {
        this.capitalUsed = capitalUsed;
    }

    private double getEnergyBalance() {
        return this.energyProduced - this.energyUsed;
    }

    private double getCapitalBalance() {
        return this.capitalEarned - this.capitalUsed;
    }
}
