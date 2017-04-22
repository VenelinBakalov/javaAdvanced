package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.waste.BaseWaste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class GarbageFactoryImpl implements Factory<Waste> {

    private static final String GARBAGE_SUFFIX = "Garbage";

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
    }};

    @Override
    public Waste create(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String garbageType = args[args.length - 1];
        Class<?> garbageClass = this.getGarbageClass(garbageType);

        Constructor<?> constructor = garbageClass.getDeclaredConstructors()[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Object[] arguments = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i].isPrimitive() ? getWrapper(parameterTypes[i]) : parameterTypes[i];
            Constructor<?> paramConstructor = parameterType.getConstructor(String.class);
            arguments[i] = paramConstructor.newInstance(args[i]);
        }

        Waste garbage = (Waste) constructor.newInstance(arguments);

//        Constructor<Waste> garbageConstructor = garbageClass.getDeclaredConstructor(String.class, double.class, double.class);
//        Waste garbage = garbageConstructor.newInstance(name, weight, volumePerKg);

        return garbage;
    }

    private Class<?> getWrapper(Class<?> parameterType) {
        return this.mapper.get(parameterType);
    }

    @SuppressWarnings("unchecked")
    private Class<Waste> getGarbageClass(String type) throws ClassNotFoundException {
        String qualifiedName = BaseWaste.class.getName();
        String simpleName = BaseWaste.class.getSimpleName();
        qualifiedName = qualifiedName.replace("." + simpleName, "." + type + GARBAGE_SUFFIX);

        return (Class<Waste>) Class.forName(qualifiedName);
    }
}
