package students;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Student {

    public static int counter = 0;
    private String name;

    public Student(String name) {
        this.name = name;
        counter++;
    }

}
