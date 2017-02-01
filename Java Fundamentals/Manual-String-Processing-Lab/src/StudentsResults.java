import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split(" - ");
            String student = input[0];
            List<Double> examResults = new ArrayList<>();

            double sum = 0;

            String[] grades = input[1].split(", ");
            for (String grade : grades) {
                double token = Double.parseDouble(grade);
                examResults.add(token);
                sum += token;
            }

            examResults.add( sum / grades.length);

            students.put(student, examResults);
        }

        if (count != 0) {
            System.out.println(String.format("%-10s|%7s|%7s|%7s|%7s|",
                    "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));

            for (String student : students.keySet()) {
                List<Double> results = students.get(student);
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", student,
                        results.get(0), results.get(1), results.get(2), results.get(3)).replace(".", ","));
            }
        }
    }
}
