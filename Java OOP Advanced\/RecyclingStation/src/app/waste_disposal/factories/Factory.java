package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public interface Factory<T> {

    T create(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
