package workForce.commandExecutor.commands;

import workForce.annotations.Inject;
import workForce.repositories.EmployeeRepository;
import workForce.jobs.Job;
import workForce.repositories.JobRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class CreateJobCommand extends BaseCommand {

    @Inject private JobRepository jobRepository;
    @Inject private EmployeeRepository employeeRepository;

    public CreateJobCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        String jobName = super.getData()[1];
        int hoursRequired = Integer.parseInt(super.getData()[2]);
        String employeeName = super.getData()[3];

        Job job = new Job(
                jobName,
                hoursRequired,
                this.employeeRepository.find(employeeName)
        );
        this.jobRepository.addJob(job);
    }
}
