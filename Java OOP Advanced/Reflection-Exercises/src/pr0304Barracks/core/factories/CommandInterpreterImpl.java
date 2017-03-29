package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.commands.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public class CommandInterpreterImpl implements pr0304Barracks.contracts.CommandInterpreter {

    private static final String COMMANDS_PACKAGE_NAME =
            "pr0304Barracks.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String commandType = commandName.toUpperCase().charAt(0) + commandName.substring(1) + COMMAND_SUFFIX;
        Class commandClass = Class.forName(COMMANDS_PACKAGE_NAME + commandType);
        Command command = null;
        Constructor[] constructors = commandClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 3) {
                constructor.setAccessible(true);
                command = (Command) constructor.newInstance(data, this.repository, this.unitFactory);
                break;
            }
        }
        return command;
    }
}
