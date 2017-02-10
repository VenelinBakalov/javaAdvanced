import java.util.Collections;
import java.util.List;

public class Student {

    private String facultyNumber ;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer group;
    private List<Integer> grades;
    private String phone;

    public Student(String facultyNumber, String firstName, String lastName, String email, Integer age, Integer group, List<Integer> grades, String phone) {
        this.facultyNumber = facultyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.group = group;
        this.grades = grades;
        this.phone = phone;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGroup() {
        return group;
    }

    public List<Integer> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    public String getPhone() {
        return phone;
    }
}
