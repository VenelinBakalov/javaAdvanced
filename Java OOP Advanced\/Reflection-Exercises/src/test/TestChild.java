package test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class TestChild extends TestAbstract {

    public static final int AGE = 15;

    public TestChild(String name) {
        super(name);
    }

    public String doSomeFinalTest() {
        return "Initial value: 15; New value: " + TestChild.AGE;
    }

    public String changeStaticFinalIntValue(int newValue) throws ReflectiveOperationException {
        Field[] fields = this.getClass().getDeclaredFields();
        Field field = this.getClass().getDeclaredField("AGE");
        field.setAccessible(true);
        System.out.println("From within the class method");
        System.out.println("Getting the declared field from this.class");
        System.out.println(field.get(null));
        System.out.println("Get static field value with TestChild.AGE " + TestChild.AGE);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        Field[] newFields = this.getClass().getDeclaredFields();
        System.out.println("field[] - " + newFields[0].get(this));
        int oldValue = (int) field.get(this);
        field.set(this, oldValue + newValue);
        System.out.println("Incrementing with the passed new value: " + newValue);
        return "new value: " + field.get(this);
    }
}
