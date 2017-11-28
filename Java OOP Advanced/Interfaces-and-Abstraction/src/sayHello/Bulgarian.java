package sayHello;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class Bulgarian implements Person {

    private String name;

    public Bulgarian(String name) {
        this.setName(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
