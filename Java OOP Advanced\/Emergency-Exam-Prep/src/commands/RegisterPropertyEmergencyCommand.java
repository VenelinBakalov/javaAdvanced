package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import models.emergencies.Emergency;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        this.setRegistrationTime(this.params[3]);
        Integer damage = Integer.valueOf(this.params[4]);

        this.emergency = new PropertyEmergency(description, level, this.registrationTime, damage);
        return super.getManagementSystem().registerPropertyEmergency(this.emergency);
    }

    private void setRegistrationTime(String time) {
        this.registrationTime = new RegistrationTimeImpl(time);
    }
}
