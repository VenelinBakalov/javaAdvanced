package main.contracts;


import main.wasteDisposal.Contracts.Waste;

public interface ManagementRequirement {

    double getMinEnergyBalance();

    double getMinCapitalBalance();

    Class getBannedWasteType();

    boolean checkWasteForProcessing(double currentEnergyBalance, double currentCapitalBalance, Waste bannedWaste);
}
