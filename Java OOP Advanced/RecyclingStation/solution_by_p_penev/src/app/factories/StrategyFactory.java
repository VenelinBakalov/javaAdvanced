package app.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StrategyFactory implements Factory<GarbageDisposalStrategy> {

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
    }};

    private String strategiesPath;

    public StrategyFactory(String wastePath) {
        this.strategiesPath = wastePath;
    }

    public GarbageDisposalStrategy create(String... args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        String type = args[args.length - 1];
        String className = strategiesPath + type + "GarbageDisposalStrategy";
        Class<?> wasteClass = Class.forName(className);

        Constructor<?> wasteConstructor = wasteClass.getDeclaredConstructors()[0];
        wasteConstructor.setAccessible(true);
        Class<?>[] wasteParameterTypes = wasteConstructor.getParameterTypes();

        Object[] wasteArguments = new Object[wasteParameterTypes.length];

        for (int i = 0; i < wasteParameterTypes.length; i++) {
            Class<?> parameterType = wasteParameterTypes[i].isPrimitive() ? getWrapper(wasteParameterTypes[i]) : wasteParameterTypes[i];
            Constructor<?> paramConstructor = parameterType.getConstructor(String.class);
            wasteArguments[i] = paramConstructor.newInstance(args[i]);
        }

        return (GarbageDisposalStrategy) wasteConstructor.newInstance(wasteArguments);
    }

    private Class<?> getWrapper(Class<?> parameterType) {
        return this.mapper.get(parameterType);
    }
}
