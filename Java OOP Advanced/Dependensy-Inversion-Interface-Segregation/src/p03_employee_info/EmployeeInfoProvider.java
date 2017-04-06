package p03_employee_info;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider {

    private EmployeeDatabase database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
    }

    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
