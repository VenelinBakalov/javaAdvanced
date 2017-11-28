package main.models;

import main.wasteDisposal.Contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData{

    private double energyBalance;
    private double capitalBalance;

    public ProcessingDataImpl(double energyBalance, double profit)
    {
        this.setEnergyBalance(energyBalance);
        this.setCapitalBalance(profit);
    }


    public double getCapitalBalance() {
        return capitalBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

    public double getEnergyBalance() {
        return energyBalance;
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }



}
