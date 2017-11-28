package hell.entities.factories;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public interface Factory<T> {

    T create(String... data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
