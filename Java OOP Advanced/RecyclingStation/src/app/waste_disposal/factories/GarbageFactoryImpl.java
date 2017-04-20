package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.waste.BaseWaste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class GarbageFactoryImpl implements GarbageFactory {

    public static final String GARBAGE_SUFFIX = "Garbage";

    @Override
    public Waste createGarbage(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Waste> garbageClass = this.getGarbageClass(type);
        Constructor<Waste> garbageConstructor = garbageClass.getDeclaredConstructor(String.class, double.class, double.class);
        Waste garbage = garbageConstructor.newInstance(name, weight, volumePerKg);

        return garbage;
    }

    @SuppressWarnings("unchecked")
    private Class<Waste> getGarbageClass(String type) throws ClassNotFoundException {
        String qualifiedName = BaseWaste.class.getName();
        String simpleName = BaseWaste.class.getSimpleName();
        qualifiedName = qualifiedName.replace("." + simpleName, "." + type + GARBAGE_SUFFIX);

        return (Class<Waste>) Class.forName(qualifiedName);
    }
}
