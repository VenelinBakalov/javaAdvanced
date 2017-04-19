package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.contracts.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class ProcessGarbageCommand implements Executable {

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

        ProcessingData data = this.processor.processWaste(waste);
        this.station.processData(data);
        return String.format("%.2f kg of %s successfully processed!", waste.getWeight(), waste.getName());
    }
}
