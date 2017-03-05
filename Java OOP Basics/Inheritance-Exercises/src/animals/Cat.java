package animals;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MiauMiau";
    }
}
