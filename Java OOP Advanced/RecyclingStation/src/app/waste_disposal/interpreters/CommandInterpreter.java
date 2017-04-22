package app.waste_disposal.interpreters;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.commands.Executable;
import app.waste_disposal.contracts.*;
import app.waste_disposal.factories.Factory;
import app.waste_disposal.models.recyclingStation.RecyclingStation;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class CommandInterpreter implements Interpreter {

    private static final String PACKAGE = "app.waste_disposal.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private String[] data;
    private GarbageProcessor garbageProcessor;
    private Factory garbageFactory;
    private RecyclingStation recyclingStation;

    public CommandInterpreter(GarbageProcessor garbageProcessor, Factory garbageFactory, RecyclingStation recyclingStation) {
        this.garbageProcessor = garbageProcessor;
        this.garbageFactory = garbageFactory;
        this.recyclingStation = recyclingStation;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String commandInfo) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String commandArgs[] = commandInfo.split("[|\\s]+");
        String commandName = commandArgs[0];

        this.data = Stream.of(commandArgs).skip(1).toArray(String[]::new);

        Class<Executable> commandClass = (Class<Executable>) Class.forName(PACKAGE + commandName + COMMAND_SUFFIX);
        Executable command = commandClass.newInstance();

        this.injectDependencies(command, commandClass);

        return command;
    }

    private void injectDependencies(Executable command, Class<Executable> commandClass) throws IllegalAccessException {
        Field[] clientFields = commandClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) continue;
            clientField.setAccessible(true);

            Field[] serviceFields = this.getClass().getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) continue;
                serviceField.setAccessible(true);
                clientField.set(command, serviceField.get(this));
            }
        }
    }
}
