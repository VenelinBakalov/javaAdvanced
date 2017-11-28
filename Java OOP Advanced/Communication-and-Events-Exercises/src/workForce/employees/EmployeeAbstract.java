package workForce.employees;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public abstract class EmployeeAbstract implements Employee {

    private String name;
    private int workHoursPerWeek;

    protected EmployeeAbstract(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
