package birthdayCelebrations;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Pet implements Birthable {

    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
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
