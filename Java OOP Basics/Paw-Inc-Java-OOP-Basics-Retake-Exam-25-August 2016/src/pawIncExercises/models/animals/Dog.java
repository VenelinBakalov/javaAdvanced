package pawIncExercises.models.animals;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class Dog extends Animal {

    private int commands;

    public Dog(String name, int age, String adoptionCenter, int commands) {
        super(name, age, adoptionCenter);
        this.commands = commands;
    }

    public Dog(String name, int age) {
        super(name, age);
    }
}
