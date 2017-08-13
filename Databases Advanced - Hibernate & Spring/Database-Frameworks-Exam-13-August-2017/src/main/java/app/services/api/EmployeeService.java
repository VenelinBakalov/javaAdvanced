package app.services.api;

import app.dto.employees.EmployeeImportXmlDto;
import app.entities.Employee;

import java.util.List;

public interface EmployeeService {

    String add(EmployeeImportXmlDto employeeImportXmlDto);
    List<Employee> findAllProductiveEmployees();
}
