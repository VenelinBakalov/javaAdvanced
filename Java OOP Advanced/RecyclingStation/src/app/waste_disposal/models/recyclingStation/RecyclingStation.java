package app.waste_disposal.models.recyclingStation;

import app.waste_disposal.models.managementRequirement.ManagementRequirement;
import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public interface RecyclingStation {

    double getEnergyBalance();

    double getCapitalBalance();

    void processData(ProcessingData data);

    ManagementRequirement getManagementRequirement();

    void setManagementRequirement(ManagementRequirement managementRequirement);
}
