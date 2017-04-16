package main.core;

import main.contracts.BalanceManager;
import main.contracts.ManagementRequirement;
import main.wasteDisposal.Contracts.ProcessingData;
import main.wasteDisposal.Contracts.Waste;


public class RecyclingStationBalanceManager implements BalanceManager {
    private double energyBalance;
    private double capitalBalance;
    private ManagementRequirement managementRequirement;

    @Override
    public double getEnergyBalance() {
        return energyBalance;
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return capitalBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

    @Override
    public ManagementRequirement getManagementRequirement() {
        return managementRequirement;
    }

    @Override
    public void setManagementRequirement(ManagementRequirement requirement) {
        this.managementRequirement = requirement;
    }

    @Override
    public void applyProcessingResult(ProcessingData result) {
        this.setEnergyBalance(this.getEnergyBalance() + result.getEnergyBalance());
        this.setCapitalBalance(this.getCapitalBalance() + result.getCapitalBalance());
    }

    @Override
    public boolean checkWasteForProcessing(Waste waste) {
        if (this.getManagementRequirement() == null)
        {
            return true;
        }

        return this.getManagementRequirement().checkWasteForProcessing(this.getEnergyBalance(), this.getCapitalBalance(), waste);
    }
}
