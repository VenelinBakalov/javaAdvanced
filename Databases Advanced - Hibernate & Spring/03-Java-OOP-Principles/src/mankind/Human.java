package mankind;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public abstract class Human {
    private String firstName;
    private String lastName;

    protected Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    private void setFirstName(String firstName) {
        if (firstName.toUpperCase().charAt(0) != firstName.charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName.toUpperCase().charAt(0) != lastName.charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName ");
        }

        this.lastName = lastName;
    }
}
