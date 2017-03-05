package companyHierarchy;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;

    public Person(Integer id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private void setId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.id = id;
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.lastName = lastName;
    }
}
