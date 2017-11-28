package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import enums.Status;
import models.emergencies.Emergency;
import models.emergencies.OrderEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class RegisterOrderEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private Emergency emergency;
    private RegistrationTime registrationTime;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        this.setRegistrationTime(this.params[3]);
        Status status = Status.valueOf(this.params[4].replaceAll("-", "_").toUpperCase());

        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }

    private void setRegistrationTime(String time) {
        this.registrationTime = new RegistrationTimeImpl(time);
    }

}
