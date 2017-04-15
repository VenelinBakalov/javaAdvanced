package workForce.employees;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class PartTimeEmployee extends EmployeeAbstract {
    private static final int PART_TIME_HOURS = 20;

    public PartTimeEmployee(String name) {
        super(name, PART_TIME_HOURS);
    }
}
