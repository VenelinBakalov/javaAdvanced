package p03_employee_info.database_layer;

import p03_employee_info.models.Employee;
import p03_employee_info.business_layer.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDatabase implements Database {

    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new Employee("Pesho", 20),
                new Employee("Gosho", 40));

        return employees;
    }
}
