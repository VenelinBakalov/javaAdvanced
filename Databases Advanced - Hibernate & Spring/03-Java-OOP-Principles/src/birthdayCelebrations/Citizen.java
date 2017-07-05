package birthdayCelebrations;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Citizen extends Identifiable implements Birthable {

    private String name;
    private int age;
    String birthdate;


    public Citizen(String name, int age, String id, String birthdate) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public boolean wasBornInYear(String year) {
        return this.birthdate.endsWith(year);
    }
}
