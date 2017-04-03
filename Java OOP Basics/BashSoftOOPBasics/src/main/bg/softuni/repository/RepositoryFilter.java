package main.bg.softuni.repository;

import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.staticData.ExceptionMessages;

import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilter {

    public void printFilteredStudents(
            HashMap<String, Double> studentsWithMarks,
            String filterType,
            Integer numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);

        if (filter == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FILTER);
        }

        int studentsCount = 0;
        for (String studentName : studentsWithMarks.keySet()) {
            if (studentsCount >= numberOfStudents) {
                break;
            }

            double mark = studentsWithMarks.get(studentName);

            if (filter.test(mark)) {
                OutputWriter.writeMessageOnNewLine(String.format(
                        "%s - %f", studentName, mark));
                studentsCount++;
            }
        }
    }

    private Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> 3.5 <= mark && mark < 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }
}
