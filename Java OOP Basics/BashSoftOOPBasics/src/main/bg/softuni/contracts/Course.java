package main.bg.softuni.contracts;

import java.util.Map;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public interface Course extends Comparable<Course> {

    String getName();

    Map<String, Student> getStudentsByName();

    void enrollStudent(Student student);
}
