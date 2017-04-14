package workForce.commands;

import workForce.JobRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class StatusCommand extends BaseCommand {

    private JobRepository repository;

    public StatusCommand(String[] data, JobRepository repository) {
        super(data);
        this.repository = repository;
    }

    @Override
    public void execute() {
        System.out.println(repository.toString());
    }
}
