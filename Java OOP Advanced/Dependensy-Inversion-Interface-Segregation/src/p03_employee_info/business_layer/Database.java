package p03_employee_info.business_layer;

import p03_employee_info.models.Employee;

import java.util.List;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public interface Database {

    List<Employee> readEmployees();

}
