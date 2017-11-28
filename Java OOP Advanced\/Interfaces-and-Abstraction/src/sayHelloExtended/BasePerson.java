package sayHelloExtended;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public abstract class BasePerson implements Person {

    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
