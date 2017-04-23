package hell.entities.commands;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public interface Executable {

    String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
