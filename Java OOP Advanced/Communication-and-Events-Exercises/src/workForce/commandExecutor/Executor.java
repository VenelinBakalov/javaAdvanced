package workForce.commandExecutor;

import workForce.commandExecutor.commands.Command;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public interface Executor {

    void executeCommand(Command command) throws IllegalAccessException;
}
