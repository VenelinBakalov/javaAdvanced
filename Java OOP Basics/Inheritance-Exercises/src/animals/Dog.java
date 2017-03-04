package animals;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Dog extends Animal {


    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("BauBau");
    }
}
