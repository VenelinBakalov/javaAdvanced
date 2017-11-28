package commands;

import core.ManagementSystem;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class EmergencyReportCommand extends BaseCommand {

    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().emergencyReport();
    }
}
