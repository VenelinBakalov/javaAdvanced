package app.waste_disposal.contracts;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public interface Interpreter {

    Executable interpretCommand(String commandInfo) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
