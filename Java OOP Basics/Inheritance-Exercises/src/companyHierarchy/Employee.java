package companyHierarchy;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Employee extends Person {

    private Double salary;
    private Department department;

    public Employee(Integer id, String firstName, String lastName, Double salary, Department department) {
        super(id, firstName, lastName);
        this.setSalary(salary);
        this.setDepartment(department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", department=" + department +
                '}';
    }

    private void setSalary(Double salary) {
        if (salary == null || salary <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.salary = salary;
    }

    private void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.department = department;
    }
}
