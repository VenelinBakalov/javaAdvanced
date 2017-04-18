package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class HealthEmergency extends BaseEmergency {

    private Integer casualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer casualties) {
        super(description, emergencyLevel, registrationTime);
        this.casualties = casualties;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.casualties;
    }
}
