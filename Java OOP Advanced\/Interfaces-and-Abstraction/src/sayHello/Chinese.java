package sayHello;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public class Chinese implements Person {

    private String name;

    public Chinese(String name) {
        this.setName(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }

    @Override
    public String getName() {
        return null;
    }

    private void setName(String name) {
        this.name = name;
    }
}
