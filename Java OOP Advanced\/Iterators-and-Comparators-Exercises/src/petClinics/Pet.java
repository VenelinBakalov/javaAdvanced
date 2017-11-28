package petClinics;

/**
 * Created by Venelin on 25.3.2017 г..
 */
public class Pet {

    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.kind;
    }
}
