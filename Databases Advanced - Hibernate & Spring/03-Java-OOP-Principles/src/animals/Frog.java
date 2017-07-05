package animals;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Frog extends Animal {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
