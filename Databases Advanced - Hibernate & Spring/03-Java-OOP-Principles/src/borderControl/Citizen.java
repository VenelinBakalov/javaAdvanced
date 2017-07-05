package borderControl;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Citizen extends Identifiable {

    private String name;
    private int age;


    public Citizen(String name, int age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }
}
