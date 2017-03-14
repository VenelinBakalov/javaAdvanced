package sayHelloExtended;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class Bulgarian extends BasePerson implements Person{

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
