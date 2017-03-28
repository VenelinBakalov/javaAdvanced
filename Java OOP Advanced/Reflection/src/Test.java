import java.lang.reflect.Constructor;

/**
 * Created by Venelin on 28.3.2017 г..
 */
public class Test {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Constructor constructor = Test.class.getConstructor(String.class);
        Test testObject =
    }
}
