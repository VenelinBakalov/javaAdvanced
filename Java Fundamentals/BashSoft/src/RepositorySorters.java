import java.util.*;

public class RepositorySorters {

    public static void printSortedStudents(HashMap<String, ArrayList<Integer>> courseData,
                                           String comparisonType,
                                           int numberOfStudents) {

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = createComparator(comparisonType);

        ArrayList<Map.Entry<String, ArrayList<Integer>>> sortedStudents = new ArrayList<>();
        sortedStudents.addAll(courseData.entrySet());

        Collections.sort(sortedStudents, comparator);

        for (Map.Entry<String, ArrayList<Integer>> student : sortedStudents) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }

    private static Comparator<Map.Entry<String, ArrayList<Integer>>> createComparator(String comparisonType) {
        switch (comparisonType) {
            case "ascending":
                return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
                    @Override
                    public int compare(Map.Entry<String, ArrayList<Integer>> firstStudent,
                                       Map.Entry<String, ArrayList<Integer>> secondStudent) {

                        Double firstStudentTotal = getTotalScore(firstStudent.getValue());
                        Double secondStudentTotal = getTotalScore(secondStudent.getValue());

                        return firstStudentTotal.compareTo(secondStudentTotal);
                    }
                };
            case "descending":
                return new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
                    @Override
                    public int compare(Map.Entry<String, ArrayList<Integer>> firstStudent,
                                       Map.Entry<String, ArrayList<Integer>> secondStudent) {

                        Double firstStudentTotal = getTotalScore(firstStudent.getValue());
                        Double secondStudentTotal = getTotalScore(secondStudent.getValue());

                        return secondStudentTotal.compareTo(firstStudentTotal);
                    }
                };
            default:
                return null;
        }
    }

    private static Double getTotalScore(ArrayList<Integer> grades) {
        Double total = 0d;

        for (Integer grade : grades) {
            total += grade;
        }

        return total / grades.size();
    }
}
