package models.emergencies;

import enums.EmergencyLevel;
import enums.Status;
import utils.RegistrationTime;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class OrderEmergency extends BaseEmergency {

    private Status status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Status status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public Integer getResultAfterProcessing() {
        switch (this.status) {
            case SPECIAL:
                return 1;
            case NON_SPECIAL:
                return 0;
            default:
                return null;
        }
    }
}
