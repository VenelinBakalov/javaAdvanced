package workForce.repositories;

import workForce.employees.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class EmployeeRepository {

    private Map<String, Employee> employees;

    public EmployeeRepository() {
        this.employees = new HashMap<>();
    }

    public void add(Employee employee) {
        this.employees.put(employee.getName(), employee);
    }

    public void remove(String employeeName) {
        this.employees.remove(employeeName);
    }

    public Employee find(String employeeName) {
        return this.employees.get(employeeName);
    }
}
