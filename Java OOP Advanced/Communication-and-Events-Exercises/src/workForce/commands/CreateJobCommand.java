package workForce.commands;

import workForce.EmployeeRepository;
import workForce.Job;
import workForce.JobRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CreateJobCommand extends BaseCommand {

    private JobRepository jobRepository;
    private EmployeeRepository employeeRepository;

    public CreateJobCommand(String[] data, JobRepository jobRepository, EmployeeRepository employeeRepository) {
        super(data);
        this.jobRepository = jobRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void execute() {
        String jobName = super.getData()[1];
        int hoursRequired = Integer.parseInt(super.getData()[2]);
        String employeeName = super.getData()[3];

        Job job = new Job(
                jobName,
                hoursRequired,
                this.employeeRepository.find(employeeName),
                this.jobRepository
        );
        this.jobRepository.add(job);
    }
}
