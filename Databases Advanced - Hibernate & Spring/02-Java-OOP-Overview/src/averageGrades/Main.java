package averageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int studentsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < studentsCount; i++) {
            String[] studentInfo = reader.readLine().split(" ");
            String name = studentInfo[0];
            List<Double> grades = new ArrayList<>();
            for (int j = 1; j < studentInfo.length; j++) {
                grades.add(Double.parseDouble(studentInfo[j]));
            }
            Student student = new Student(name, grades);
            student.calculateAverageGrade();
            students.add(student);
        }

        students.stream().filter(s -> s.getAverageGrade() >= 5)
                .sorted((s1, s2) -> {
                    int result = s1.getName().compareTo(s2.getName());
                    if (result == 0) {
                        result = Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
                    }
                    return result;})
                .forEach(System.out::println);
    }
}
