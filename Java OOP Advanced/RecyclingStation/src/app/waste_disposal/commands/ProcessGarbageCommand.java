package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.contracts.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class ProcessGarbageCommand implements Executable {

    public static final String GARBAGE_SUFFIX = "Garbage";
    public static final String EMPTY_STRING = "";
    public static final String RESULT_MESSAGE = "%.2f kg of %s successfully processed!";
    public static final String PROCESSING_DENIED_MESSAGE = "Processing Denied!";
    @Inject private GarbageProcessor processor;
    @Inject private GarbageFactory factory;
    @Inject private RecyclingStation station;
    @Inject private String[] commandArgs;

    @Override
    public String execute() {
        String name = this.commandArgs[0];
        double weight = Double.parseDouble(commandArgs[1]);
        double volumePerKg = Double.parseDouble(commandArgs[2]);
        String type = commandArgs[3];
        Waste waste = null;

        try {
            waste = this.factory.createGarbage(name, weight, volumePerKg, type);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        if (this.station.getManagementRequirement() != null) {
            ManagementRequirement requirement = this.station.getManagementRequirement();
            String garbageTypeRequirement = requirement.getWasteType();
            String garbageType = waste.getClass().getSimpleName().replace(GARBAGE_SUFFIX, EMPTY_STRING);
            if (garbageType.equals(garbageTypeRequirement)
                    && (requirement.getMinEnergyBalance() > this.station.getEnergyBalance()
                    || requirement.getMinCapitalBalance() > this.station.getCapitalBalance())) {
                return PROCESSING_DENIED_MESSAGE;
            }
        }

        ProcessingData data = this.processor.processWaste(waste);
        this.station.processData(data);
        return String.format(RESULT_MESSAGE, waste.getWeight(), waste.getName());
    }
}
