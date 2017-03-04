package animals;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Tomcat extends Cat {
    private static final String GENDER = "male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }
}
