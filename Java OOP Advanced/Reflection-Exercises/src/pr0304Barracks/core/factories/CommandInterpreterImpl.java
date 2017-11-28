package pr0304Barracks.core.factories;

import pr0304Barracks.annotations.Alias;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.Injector;
import pr0304Barracks.core.commands.Command;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public class CommandInterpreterImpl implements pr0304Barracks.contracts.CommandInterpreter {

    private static final String COMMANDS_PACKAGE_NAME =
            "pr0304Barracks.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private static final String COMMANDS_LOCATION = "src/pr0304Barracks/core/commands";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        //  File commandsFolder = new File(COMMANDS_LOCATION);
        //  Executable executable = null;

        //  for (File file : commandsFolder.listFiles()) {
        //      if (!file.isFile() || !file.getName().endsWith(".java")) {
        //          continue;
        //      }
        //      try {
        //          String className = file.getName().substring(0, file.getName().lastIndexOf('.'));
        //          Class<Executable> executableClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE_NAME + className);

        //          if (!executableClass.isAnnotationPresent(Alias.class)) {
        //              continue;
        //          }
        //          Alias alias = executableClass.getAnnotation(Alias.class);
        //          String value = alias.value();
        //          if (!value.equalsIgnoreCase(commandName)) {
        //              continue;
        //          }

        //          Constructor executableConstructor = executableClass.getConstructor(String[].class);
        //          executable = (Executable) executableConstructor.newInstance((Object) data);
        //          this.injectDependencies(executable, executableClass);
        //          break;
        //      } catch (ReflectiveOperationException rfe) {

        //      }
        //  }

        //  return executable;

        Executable command = null;

        String commandType = commandName.toUpperCase().charAt(0) + commandName.substring(1) + COMMAND_SUFFIX;
        try {
            Class commandClass = Class.forName(COMMANDS_PACKAGE_NAME + commandType);
            Constructor[] constructors = commandClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                if (constructor.getParameterCount() == 1) {
                    command = (Executable) constructor.newInstance((Object) data);
                    Injector.injectDependencies(command, this);
                    //this.injectDependencies(command, commandClass);
                    break;
                }
            }
        } catch (ReflectiveOperationException rfe) {
        }
        return command;
    }

    private void injectDependencies(Executable executable, Class<Executable> executableClass) throws ReflectiveOperationException {
        Field[] clientFields = executableClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (!clientField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            clientField.setAccessible(true);

            Field[] serviceFields = CommandInterpreterImpl.class.getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (!serviceField.getType().equals(clientField.getType())) {
                    continue;
                }
                serviceField.setAccessible(true);
                clientField.set(executable, serviceField.get(this));
            }
        }
    }
}
