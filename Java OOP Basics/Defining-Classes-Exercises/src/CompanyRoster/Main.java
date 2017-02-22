package companyRoster;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int employeeCount = Integer.parseInt(reader.readLine());

        Map<String, Set<Employee>> departments = new HashMap<>();

        for (int i = 0; i < employeeCount; i++) {
            String[] employeeInformation = reader.readLine().split(" ");
            String name = employeeInformation[0];
            double salary = Double.parseDouble(employeeInformation[1]);
            String position = employeeInformation[2];
            String department = employeeInformation[3];
            Employee employee = new Employee(name, salary, position, department);

            if (employeeInformation.length == 5) {
                if (Character.isDigit(employeeInformation[4].charAt(0))) {
                    int age = Integer.parseInt(employeeInformation[4]);
                    employee.setAge(age);
                } else {
                    String email = employeeInformation[4];
                    employee.setEmail(email);
                }
            } else if (employeeInformation.length == 6) {
                String email = employeeInformation[4];
                int age = Integer.parseInt(employeeInformation[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }

            departments.putIfAbsent(department, new HashSet<>());
            departments.get(department).add(employee);
        }

        departments.entrySet().stream()
                .sorted((d1, d2) ->
                        Double.compare(d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                                d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getKey());
                    d.getValue().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(System.out::println);
                });
    }
}
