package workForce.employees;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class StandartEmployee extends EmployeeAbstract {
    private static final int STANDARD_HOURS = 40;

    public StandartEmployee(String name) {
        super(name, STANDARD_HOURS);
    }
}
