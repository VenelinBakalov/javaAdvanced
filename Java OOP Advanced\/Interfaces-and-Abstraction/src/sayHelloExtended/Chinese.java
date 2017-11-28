package sayHelloExtended;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class Chinese extends BasePerson implements Person {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
