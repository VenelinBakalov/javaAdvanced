package commandInterpreter;

import annotations.Alias;
import annotations.Inject;
import models.BlobsRepository;
import factories.AttackFactory;
import factories.BehaviorFactory;
import interfaces.Executable;
import interfaces.OutputWriter;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class CommandInterpreter {
    private static final String COMMANDS_LOCATION = "src/commandInterpreter/commands";
    private static final String COMMANDS_PACKAGE = "commandInterpreter.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private OutputWriter writer;
    private AttackFactory attackFactory;
    private BehaviorFactory behaviorFactory;
    private BlobsRepository repository;

    public CommandInterpreter(OutputWriter writer, AttackFactory attackFactory, BehaviorFactory behaviorFactory, BlobsRepository repository) {
        this.writer = writer;
        this.attackFactory = attackFactory;
        this.behaviorFactory = behaviorFactory;
        this.repository = repository;
    }

    public void interpretCommand(String input) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String[] data = input.split(" ");
        String commandName = data[0].toLowerCase();
//        String[] commandTypeArgs = data[0].split("-");
//        String commandName;
//        if (commandTypeArgs.length == 1) {
//            commandName = commandTypeArgs[0].toUpperCase().charAt(0) + commandTypeArgs[0].substring(1) + COMMAND_SUFFIX;
//        } else {
//            commandName = commandTypeArgs[0].toUpperCase().charAt(0) + commandTypeArgs[0].substring(1)
//                    + commandTypeArgs[1].toUpperCase().charAt(0) + commandTypeArgs[1].substring(1)
//                    + COMMAND_SUFFIX;
//        }

        Executable command = parseCommand(data, commandName);
        command.execute();
    }

    private Executable parseCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File commandsFolder = new File(COMMANDS_LOCATION);
        Executable command = null;

        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }
            String className = file.getName().substring(0, file.getName().lastIndexOf('.'));
            Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);

            if (!commandClass.isAnnotationPresent(Alias.class)) {
                continue;
            }
            Alias alias = commandClass.getAnnotation(Alias.class);
            String value = alias.value();
            if (!value.equalsIgnoreCase(commandName)) {
                continue;
            }

            Constructor<Executable> constructor = commandClass.getConstructor(String[].class);
            command = constructor.newInstance((Object) data);
            this.injectDependencies(command, commandClass);
            break;
        }

        return command;


//        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + commandName);
//        Constructor<Executable> constructor = commandClass.getDeclaredConstructor(String[].class);
//        Executable command = constructor.newInstance((Object) data);
//        this.injectDependencies(command, commandClass);
//        return command;
    }

    private void injectDependencies(Executable command, Class<Executable> commandClass) throws IllegalAccessException {
        Field[] clientFields = commandClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            clientField.setAccessible(true);

            Field[] serviceFields = CommandInterpreter.class.getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) {
                    continue;
                }
                serviceField.setAccessible(true);

                clientField.set(command, serviceField.get(this));
                break;
            }
        }
    }
}
