import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Venelin on 28.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;
        Method[] allMethods = reflectionClass.getDeclaredMethods();

        Method[] allGetters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("get"))
                .toArray(Method[]::new);

        Method[] allSetters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("set"))
                .toArray(Method[]::new);


        Field[] allFields = reflectionClass.getDeclaredFields();
        Arrays.sort(allFields, Comparator.comparing(Field::getName));

        for (Field field : allFields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.println(String.format("%s must be private!", field.getName()));
            }
        }

        Arrays.sort(allGetters, Comparator.comparing(Method::getName));
        Arrays.sort(allSetters, Comparator.comparing(Method::getName));

        for (Method getter : allGetters) {
            if (!Modifier.isPublic(getter.getModifiers())) {
                System.out.println(String.format("%s have to be public!", getter.getName()));
            }
        }

        for (Method setter : allSetters) {
            if (void.class.equals(setter.getReturnType())) {
                if (setter.getParameterCount() == 1) {
                    if (!Modifier.isPrivate(setter.getModifiers())) {
                        System.out.println(String.format("%s have to be private!", setter.getName()));
                    }
                }
            }
        }

    }

    public static void secondTaskMain(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;
        Method[] allMethods = reflectionClass.getDeclaredMethods();

        Method[] allGetters = Arrays.stream(allMethods)
                .filter(m -> (m.getName().startsWith("get")) && m.getParameterTypes().length == 0)
                .toArray(Method[]::new);

        Method[] allSetters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("set"))
                .toArray(Method[]::new);

        Arrays.sort(allGetters, Comparator.comparing(Method::getName));
        Arrays.sort(allSetters, Comparator.comparing(Method::getName));

        for (Method getter : allGetters) {
            System.out.println(String.format("%s will return %s", getter.getName(), getter.getReturnType()));
        }

        for (Method setter : allSetters) {
            if (void.class.equals(setter.getReturnType())) {
                if (setter.getParameterCount() == 1) {
                    System.out.println(String.format("%s and will set field of %s",
                            setter.getName(), setter.getParameterTypes()[0]));
                }
            }
        }
    }

    public static void firstTaskMain(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);

        Class superClass = reflectionClass.getSuperclass();
        System.out.println(superClass);

        Class[] reflectionClassInterfaces = reflectionClass.getInterfaces();
        for (Class reflectionClassInterface : reflectionClassInterfaces) {
            System.out.println(reflectionClassInterface);
        }

        Reflection reflection = (Reflection) reflectionClass.newInstance();
        System.out.println(reflection);
    }
}

