package core;

import models.emergencies.Emergency;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public interface ManagementSystem {

    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency();

    String registerOrderEmergency();

    String registerFireServiceCenter();

    String registerMedicalServiceCenter();

    String registerPoliceServiceCenter();

    String processEmergencies();

    String emergencyReport();
}
