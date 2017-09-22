package p03_employee_info.user_interface;

import p03_employee_info.models.Employee;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public interface InfoProvider {

    List<Employee> getEmployeesBy(Comparator<Employee> comparator);

}
