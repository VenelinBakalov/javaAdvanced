package app.factories;

import java.lang.reflect.InvocationTargetException;

public interface Factory<T> {
    T create(String... args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException;
}
