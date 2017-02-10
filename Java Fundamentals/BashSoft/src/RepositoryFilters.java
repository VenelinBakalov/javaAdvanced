import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilters {

    public static void printFilteredStudents(HashMap<String, ArrayList<Integer>> courseData,
                                             String filterType,
                                             Integer numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);

        if (filter == null) {
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsPrinted = 0;

        for (String student : courseData.keySet()) {
            if (studentsPrinted >= numberOfStudents) {
                break;
            }

            ArrayList<Integer> studentMarks = courseData.get(student);
            Double averageMark = getStudentAverageGrade(studentMarks);

            if (filter.test(averageMark)) {
                OutputWriter.printStudent(student, studentMarks);
                studentsPrinted++;
            }
        }
    }

    private static Predicate<Double> createFilter(String filterType) {
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

    private static Double getStudentAverageGrade(ArrayList<Integer> grades) {
        Double totalScore = 0d;

        for (Integer grade : grades) {
            totalScore += grade;
        }

        Double percentage = totalScore / (grades.size() * 100.0);
        return (percentage * 4) + 2;
    }
}
