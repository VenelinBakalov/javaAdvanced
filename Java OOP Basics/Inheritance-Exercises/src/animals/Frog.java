package animals;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Frog extends Animal {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Frogggg");
    }
}
