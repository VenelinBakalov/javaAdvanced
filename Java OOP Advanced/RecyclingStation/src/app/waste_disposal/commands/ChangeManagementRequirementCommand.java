package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.models.managementRequirement.ManagementRequirement;
import app.waste_disposal.models.recyclingStation.RecyclingStation;
import app.waste_disposal.models.managementRequirement.ManagementRequirementImpl;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class ChangeManagementRequirementCommand implements Executable {

    private static final String MANAGEMENT_REQUIREMENT_CHANGED_MESSAGE = "Management requirement changed!";
    @Inject private String[] data;
    @Inject private RecyclingStation recyclingStation;

    @Override
    public String execute() {
        double minEnergyBalance = Double.parseDouble(this.data[0]);
        double minCapitalBalance = Double.parseDouble(this.data[1]);
        String wasteType = this.data[2];

        ManagementRequirement managementRequirement = new ManagementRequirementImpl(
                minEnergyBalance,
                minCapitalBalance,
                wasteType);

        this.recyclingStation.setManagementRequirement(managementRequirement);

        return MANAGEMENT_REQUIREMENT_CHANGED_MESSAGE;
    }
}
