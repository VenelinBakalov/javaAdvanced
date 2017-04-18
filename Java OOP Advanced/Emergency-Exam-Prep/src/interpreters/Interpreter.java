package interpreters;

import commands.Executable;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public interface Interpreter {

    Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
