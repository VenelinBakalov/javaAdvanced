package animals;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Kitten extends Cat {
    private static final String GENDER = "female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }
}
