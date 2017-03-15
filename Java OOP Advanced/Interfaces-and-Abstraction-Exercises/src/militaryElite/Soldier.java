package militaryElite;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public abstract class Soldier implements ISoldier {

    private String id;
    private String firstName;
    private String lastName;

    protected Soldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s", this.firstName, this.lastName, this.id);
    }
}
