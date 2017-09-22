import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 28.3.2017 г..
 */
public class Test {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = Test.class.getConstructor(String.class);
        Test testObject = (Test) constructor.newInstance("gosho");
        System.out.println(testObject);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
