package workForce.commands;

import workForce.JobRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class PassWeekCommand extends BaseCommand {

    private JobRepository repository;

    public PassWeekCommand(String[] data, JobRepository repository) {
        super(data);
        this.repository = repository;
    }

    @Override
    public void execute() {
        this.repository.update();
    }
}
