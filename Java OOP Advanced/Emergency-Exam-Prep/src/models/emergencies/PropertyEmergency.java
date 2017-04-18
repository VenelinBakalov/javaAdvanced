package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public class PropertyEmergency extends BaseEmergency {

    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.damage;
    }
}
