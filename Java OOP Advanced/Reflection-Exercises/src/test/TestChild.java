package test;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public class TestChild extends TestAbstract {

    private static final int AGE = 15;

    public TestChild(String name) {
        super(name);
    }

    public String doSomeFinalTest() {
        return "Initial value: 15; New value: " + TestChild.AGE;
    }
}
