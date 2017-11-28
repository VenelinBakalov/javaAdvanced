package foodShortage;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Citizen implements Identifiable, Birthable, Buyer {

    private static final int FOOD_INCREASE = 10;

    private String name;
    private int age;
    private String id;
    private String birthdate;
    private int food;

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

    @Override
    public void buyFood() {
        this.food += FOOD_INCREASE;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
