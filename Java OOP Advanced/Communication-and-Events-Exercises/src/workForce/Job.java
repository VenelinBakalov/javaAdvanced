package workForce;


import workForce.employees.Employee;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private JobRepository repository;

    public Job(String name, int hoursOfWorkRequired, Employee employee, JobRepository repository) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
        this.repository = repository;
    }

    public void update() {
        this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();

        if (this.hoursOfWorkRequired <= 0) {
            System.out.println(String.format("Job %s done!", this.name));
            this.repository.remove(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.name, this.hoursOfWorkRequired);
    }
}
