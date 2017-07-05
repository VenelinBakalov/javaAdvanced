package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] studentArgs = reader.readLine().split(" ");
            String[] workerArgs = reader.readLine().split(" ");

            String studentFirstName = studentArgs[0];
            String studentLastName = studentArgs[1];
            String facultyNumber = studentArgs[2];
            Student student = new Student(studentFirstName, studentLastName, facultyNumber);

            String workerFirstName = workerArgs[0];
            String workerLastName = workerArgs[1];
            double weekSalary = Double.parseDouble(workerArgs[2]);
            double hoursPerDay = Double.parseDouble(workerArgs[3]);
            Worker worker = new Worker(workerFirstName, workerLastName, weekSalary, hoursPerDay);

            System.out.println(student);
            System.out.println();
            System.out.println(worker);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
