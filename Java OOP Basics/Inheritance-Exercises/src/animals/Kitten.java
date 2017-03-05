package animals;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Kitten extends Cat {
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
