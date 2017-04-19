package app.waste_disposal.contracts;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public interface GarbageFactory {

    Waste createGarbage(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
