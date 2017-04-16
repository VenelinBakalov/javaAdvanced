package main.models;


import main.contracts.ManagementRequirement;
import main.wasteDisposal.Contracts.Waste;
import main.wasteDisposal.annotations.Disposable;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class RecyclingStationManagementRequirement implements ManagementRequirement {

    private double minEnergyBalance;
    private double minCapitalBalance;
    private Class bannedWasteClass;

    public RecyclingStationManagementRequirement(double energyBalance, double capitalBalance, Class deniedType)
    {
        this.setMinEnergyBalance(energyBalance);
        this.setMinCapitalBalance(capitalBalance);
        this.setBannedWasteClass(deniedType);
    }

    private void setMinEnergyBalance(double minEnergyBalance) {
        this.minEnergyBalance = minEnergyBalance;
    }

    private void setMinCapitalBalance(double minCapitalBalance) {
        this.minCapitalBalance = minCapitalBalance;
    }

    //checks if the waste Type does not inherit from Waste interface, is abstract or does not implement an annotation with @Disposable
    private void setBannedWasteClass(Class bannedWasteClass) {
        if (!(Waste.class.isAssignableFrom(bannedWasteClass)) ||
                Modifier.isAbstract(bannedWasteClass.getModifiers()) ||
                !Arrays.stream(bannedWasteClass.getAnnotations()).anyMatch(x->x.annotationType().isAnnotationPresent(Disposable.class)))
        {
            throw new IllegalArgumentException("The passed in type either does not inherit from Waste, is abstract or does not implement an annotation with @Disposable!");
        }

        this.bannedWasteClass = bannedWasteClass;
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
    public Class getBannedWasteType() {
        return this.bannedWasteClass;
    }

    @Override
    public boolean checkWasteForProcessing(double currentEnergyBalance, double currentCapitalBalance, Waste bannedWaste) {
        if (currentCapitalBalance < this.minCapitalBalance || currentEnergyBalance < this.minEnergyBalance)
        {
            if (bannedWaste.getClass() == this.bannedWasteClass)
            {
                return false;
            }
        }

        return true;
    }
}
