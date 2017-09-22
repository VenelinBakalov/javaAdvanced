package workForce.commandExecutor.commands;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public abstract class BaseCommand implements Command {

    private String[] data;

    protected BaseCommand(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }
}
