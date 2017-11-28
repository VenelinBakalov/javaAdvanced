package app.core;

import app.waste_disposal.contracts.ProcessingData;

public interface BalanceManager {
    void processData(ProcessingData processingData);
    double getEnergyBalance();
    double getCapitalBalance();
}
