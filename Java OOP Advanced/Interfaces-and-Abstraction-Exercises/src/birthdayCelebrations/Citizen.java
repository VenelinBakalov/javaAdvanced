package birthdayCelebrations;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Citizen implements Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public boolean isFake(String id) {
        return this.id.endsWith(id);
    }

    @Override
    public String getId() {
        return id;
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
