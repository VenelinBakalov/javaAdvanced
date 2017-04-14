package workForce.employees;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public abstract class Employee {

    private String name;
    private int workHoursPerWeek;

    protected Employee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
