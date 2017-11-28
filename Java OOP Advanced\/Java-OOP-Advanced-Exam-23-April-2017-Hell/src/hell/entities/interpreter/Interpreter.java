package hell.entities.interpreter;

import hell.entities.commands.Executable;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public interface Interpreter {

    Executable interpretCommand(String command) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
