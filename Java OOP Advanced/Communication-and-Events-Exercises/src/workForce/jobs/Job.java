package workForce.jobs;


import workForce.employees.Employee;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private Listener listener;
    private boolean isDone;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void update() {
        this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();

        if (this.listener != null && this.hoursOfWorkRequired <= 0) {
            this.listener.handle(new JobDoneEvent(this, this.name));
            this.isDone = true;
        }

    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.name, this.hoursOfWorkRequired);
    }
}
