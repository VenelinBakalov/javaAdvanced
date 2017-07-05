package animals;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Dog extends Animal {


    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}
