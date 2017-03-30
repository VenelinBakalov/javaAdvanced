package test;

import java.lang.reflect.*;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class testClass = TestAbstract.class;

        Field modifiersField = Class.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(testClass, testClass.getModifiers() & ~Modifier.ABSTRACT);

        TestAbstract test = null;

        Constructor[] constructors = testClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 1) {
                constructor.setAccessible(true);
                test = (TestAbstract) constructor.newInstance("Pesho");
            }
        }

        System.out.println(test.getName());
    }
}
