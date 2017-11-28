package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import models.emergencies.Emergency;
import models.emergencies.HealthEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class RegisterHealthEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterHealthEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        this.setRegistrationTime(this.params[3]);
        Integer casualties = Integer.valueOf(this.params[4]);

        this.emergency = new HealthEmergency(description, level, this.registrationTime, casualties);
        return super.getManagementSystem().registerHealthEmergency(this.emergency);
    }

    private void setRegistrationTime(String time) {
        this.registrationTime = new RegistrationTimeImpl(time);
    }

}
