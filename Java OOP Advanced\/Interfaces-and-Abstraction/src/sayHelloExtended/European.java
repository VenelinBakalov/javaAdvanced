package sayHelloExtended;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class European extends BasePerson implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
