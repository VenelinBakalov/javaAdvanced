package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public void execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());

    }

    private void setRegistrationTime() {

    }
}
