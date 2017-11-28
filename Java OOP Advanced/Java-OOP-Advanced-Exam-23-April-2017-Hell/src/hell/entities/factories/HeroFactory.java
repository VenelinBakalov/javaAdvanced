package hell.entities.factories;

import hell.entities.heroes.BaseHero;
import hell.interfaces.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class HeroFactory implements Factory<Hero> {

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
    }};

    @Override
    public Hero create(String... data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String heroType = data[data.length - 1];
        Class<?> heroClass = this.getHeroClassByType(heroType);

        Constructor<?> heroConstructor = heroClass.getDeclaredConstructors()[0];
        Class<?>[] parameterTypes = heroConstructor.getParameterTypes();

        Object[] arguments = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i].isPrimitive() ?
                    this.getWrapper(parameterTypes[i]) :
                    parameterTypes[i];

            Constructor<?> parameterConstructor = parameterType.getConstructor(String.class);
            arguments[i] = parameterConstructor.newInstance(data[i]);
        }

        Hero hero = (Hero) heroConstructor.newInstance(arguments);

        return hero;
    }

    private Class<?> getWrapper(Class<?> parameterType) {
        return this.mapper.get(parameterType);
    }

    private Class<?> getHeroClassByType(String heroType) throws ClassNotFoundException {
        String qualifiedName = BaseHero.class.getName();
        String simpleName = BaseHero.class.getSimpleName();
        qualifiedName = qualifiedName.replace("." + simpleName, "." + heroType);

        return Class.forName(qualifiedName);
    }
}
