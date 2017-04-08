package commandInterpreter.commands;

import annotations.Inject;
import models.BlobsRepository;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class PassCommand extends Command {

    @Inject private BlobsRepository repository;

    public PassCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        this.repository.update();
    }
}
