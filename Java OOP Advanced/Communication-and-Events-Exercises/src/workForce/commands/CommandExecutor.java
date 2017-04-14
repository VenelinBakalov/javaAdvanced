package workForce.commands;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
