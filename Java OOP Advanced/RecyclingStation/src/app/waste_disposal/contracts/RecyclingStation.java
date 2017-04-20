package app.waste_disposal.contracts;

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
