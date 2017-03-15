package militaryElite;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Spy extends Soldier implements ISpy {

    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCode Number: " + this.codeNumber;
    }
}
