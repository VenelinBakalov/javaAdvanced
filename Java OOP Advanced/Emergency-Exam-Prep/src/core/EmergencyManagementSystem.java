package core;

import collection.Register;
import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

import java.util.HashMap;
import java.util.Map;

public class EmergencyManagementSystem implements ManagementSystem {

    public static final String PROPERTY = "Property";
    public static final String HEALTH = "Health";
    public static final String ORDER = "Order";
    public static final String REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_S_AT_S = "Registered Public %s Emergency of level %s at %s.";
    private Map<String, Register<Emergency>> emergencies;
    private Map<String, Register<EmergencyCenter>> centers;
    private Map<String, Long> processedEmergencies;


    public EmergencyManagementSystem() {
        this.initEmergencies();
        this.initCenters();
        this.initProcessedEmergencies();
    }

    private void initProcessedEmergencies() {
        this.processedEmergencies = new HashMap<>();
        this.processedEmergencies.put(PROPERTY, 0L);
        this.processedEmergencies.put(HEALTH, 0L);
        this.processedEmergencies.put(ORDER, 0L);
    }

    private void initCenters() {
        this.centers = new HashMap<>();
    }

    private void initEmergencies() {
        this.emergencies = new HashMap<>();
//        this.emergencies.put("Property", );
    }


    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        return String.format(REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_S_AT_S,
                PROPERTY, emergency.getEmergencyLevel());
    }

    @Override
    public String registerHealthEmergency() {
        return null;
    }

    @Override
    public String registerOrderEmergency() {
        return null;
    }

    @Override
    public String registerFireServiceCenter() {
        return null;
    }

    @Override
    public String registerMedicalServiceCenter() {
        return null;
    }

    @Override
    public String registerPoliceServiceCenter() {
        return null;
    }

    @Override
    public String processEmergencies() {
        return null;
    }

    @Override
    public String emergencyReport() {
        return null;
    }
}
