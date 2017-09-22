package app.models;

import app.waste_disposal.contracts.ProcessingData;

public class WasteData implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    public WasteData(double energyBalance, double capitalBalance) {
        this.energyBalance = energyBalance;
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}
