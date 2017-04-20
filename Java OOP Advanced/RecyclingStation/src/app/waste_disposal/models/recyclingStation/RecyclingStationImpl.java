package app.waste_disposal.models.recyclingStation;

import app.waste_disposal.models.managementRequirement.ManagementRequirement;
import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class RecyclingStationImpl implements RecyclingStation {

    private double energyBalance;
    private double capitalBalance;
    private ManagementRequirement managementRequirement;


    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    @Override
    public void processData(ProcessingData data) {
        this.energyBalance += data.getEnergyBalance();
        this.capitalBalance += data.getCapitalBalance();
    }

    @Override
    public ManagementRequirement getManagementRequirement() {
        return managementRequirement;
    }

    @Override
    public void setManagementRequirement(ManagementRequirement managementRequirement) {
        this.managementRequirement = managementRequirement;
    }
}
