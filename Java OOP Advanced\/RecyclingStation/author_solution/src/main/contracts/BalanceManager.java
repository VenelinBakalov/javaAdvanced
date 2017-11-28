package main.contracts;


import main.wasteDisposal.Contracts.ProcessingData;
import main.wasteDisposal.Contracts.Waste;

public interface BalanceManager {

    double getEnergyBalance();

    double getCapitalBalance();

    ManagementRequirement getManagementRequirement();

    void setManagementRequirement(ManagementRequirement requirement);

    void applyProcessingResult(ProcessingData result);

    boolean checkWasteForProcessing(Waste waste);
}
