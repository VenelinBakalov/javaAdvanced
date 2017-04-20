package app.waste_disposal.models;

import app.waste_disposal.contracts.ManagementRequirement;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class ManagementRequirementImpl implements ManagementRequirement {

    private double minEnergyBalance;
    private double minCapitalBalance;
    private String wasteType;

    public ManagementRequirementImpl(double minEnergyBalance, double minCapitalBalance, String wasteType) {
        this.minEnergyBalance = minEnergyBalance;
        this.minCapitalBalance = minCapitalBalance;
        this.wasteType = wasteType;
    }

    @Override
    public double getMinEnergyBalance() {
        return this.minEnergyBalance;
    }

    @Override
    public double getMinCapitalBalance() {
        return this.minCapitalBalance;
    }

    @Override
    public String getWasteType() {
        return wasteType;
    }
}
