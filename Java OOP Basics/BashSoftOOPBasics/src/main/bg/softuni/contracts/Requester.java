package main.bg.softuni.contracts;

import main.bg.softuni.dataStructures.SimpleSortedList;

import java.util.Comparator;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public interface Requester {

    void getStudentMarkInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp);
}
