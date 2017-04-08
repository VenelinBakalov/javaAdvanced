package commandInterpreter.commands;

import annotations.Inject;
import models.BlobsRepository;

/**
 * Created by Venelin on 8.4.2017 г..
 */
public class ReportEventsCommand extends Command {

    @Inject private BlobsRepository repository;

    public ReportEventsCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute() {
        this.repository.triggerReportEvents();
    }
}
