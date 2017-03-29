package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.InvalidStringException;
import bg.softuni.exceptions.KeyNotFoundException;
import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 28.2.2017 г..
 */
public class Student {

    private String userName;
    private Map<String, Course> enrolledCourses;
    private Map<String, Double> marksByCourseName;

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
            throw new DuplicateEntryInStructureException(this.userName, course.getName());
        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarkOnCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
           throw new KeyNotFoundException();
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        // return new LinkedHashMap<>(this.enrolledCourses);
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    private void setUserName(String userName) {
        if (userName == null || userName.equals("")) {
            throw new InvalidStringException();
        }
        this.userName = userName;
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
