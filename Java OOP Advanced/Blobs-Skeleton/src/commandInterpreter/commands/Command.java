package commandInterpreter.commands;

import interfaces.Executable;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
