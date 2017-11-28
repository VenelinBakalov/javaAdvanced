package test;

import java.lang.reflect.*;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {

        Class<TestChild> testChildClass = TestChild.class;

        Field field = testChildClass.getDeclaredField("AGE");
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, 1000);
        System.out.println("Changed field value:");
        System.out.println(field.get(null));

        System.out.println();
        System.out.println("First child tests:");
        TestChild child = new TestChild("private static final field test");
        field.set(child, 1000);
        System.out.println(child.doSomeFinalTest());
        System.out.println(field.get(child));

        System.out.println();
        System.out.println("Second child tests:");

        TestChild secondChild = testChildClass.getConstructor(String.class).newInstance("Second test");
        field.set(secondChild, 180);
        System.out.println(secondChild.doSomeFinalTest());
        System.out.println(field.get(secondChild));

        System.out.println();
        System.out.println("Static field test");
        System.out.println(TestChild.AGE);

        System.out.println();
        System.out.println("Try class method:");
        System.out.println(child.changeStaticFinalIntValue(1000));

    //  Class testClass = TestAbstract.class;

    //  Field modifiersField = Class.class.getDeclaredField("modifiers");
    //  modifiersField.setAccessible(true);
    //  modifiersField.setInt(testClass, testClass.getModifiers() & ~Modifier.ABSTRACT);

    //  TestAbstract test = null;

    //  Constructor[] constructors = testClass.getDeclaredConstructors();
    //  for (Constructor constructor : constructors) {
    //      if (constructor.getParameterCount() == 1) {
    //          constructor.setAccessible(true);
    //          test = (TestAbstract) constructor.newInstance("Pesho");
    //      }
    //  }

    //  System.out.println(test.getName());
    }
}
