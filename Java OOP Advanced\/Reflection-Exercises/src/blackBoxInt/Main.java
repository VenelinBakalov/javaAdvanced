package blackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Venelin on 28.3.2017 г..
 */
public class Main {
    private static final String FIELD_NAME = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        Class blackBoxClass = BlackBoxInt.class;
        Constructor[] constructors = blackBoxClass.getDeclaredConstructors();
        BlackBoxInt blackBox = null;
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 1 && int.class.equals(constructor.getParameterTypes()[0])) {
                constructor.setAccessible(true);
                blackBox = (BlackBoxInt) constructor.newInstance(0);
                break;
            }
        }


        String command;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("_");
            String commandType = commandArgs[0];
            int value = Integer.parseInt(commandArgs[1]);

            Method[] methods = blackBoxClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(commandType)) {
                    method.setAccessible(true);
                    method.invoke(blackBox, value);
                    break;
                }
            }

            Field[] fields = blackBoxClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(FIELD_NAME));
                field.setAccessible(true);
                System.out.println(field.get(blackBox));
                break;
            }
        }
    }
}
