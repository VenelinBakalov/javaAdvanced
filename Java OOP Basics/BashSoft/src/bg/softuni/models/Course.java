package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.InvalidStringException;
import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 28.2.2017 г..
 */
public class Course {
    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private Map<String, Student> studentsByName;

    public Course(String name) {
        this.name = name;
        this.studentsByName = new LinkedHashMap<>();
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUserName())) {
            throw new DuplicateEntryInStructureException(student.getUserName(), this.name);
        }

        this.studentsByName.put(student.getUserName(), student);
    }

    public String getName() {
        return name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new InvalidStringException();
        }
        this.name = name;
    }
}
