package workForce.commandExecutor.commands;

import workForce.annotations.Inject;
import workForce.repositories.JobRepository;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class PassWeekCommand extends BaseCommand {

    @Inject private JobRepository repository;

    public PassWeekCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        this.repository.update();
    }
}
