package app.waste_disposal.models.data;

import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by Venelin on 19.4.2017 г..
 */
public class ProcessingDataImpl implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    public ProcessingDataImpl(double energyBalance, double capitalBalance) {
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
