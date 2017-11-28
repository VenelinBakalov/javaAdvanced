package commands;

import annotations.InjectType;
import core.ManagementSystem;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class ProcessEmergenciesCommand extends BaseCommand {

    @InjectType
    private String type;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}
