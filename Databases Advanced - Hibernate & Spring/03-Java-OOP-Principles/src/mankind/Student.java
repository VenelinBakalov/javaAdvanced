package mankind;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Student extends Human {

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Faculty number: ").append(this.getFacultyNumber());

        return sb.toString();
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || 10 < facultyNumber.length()) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }
}
