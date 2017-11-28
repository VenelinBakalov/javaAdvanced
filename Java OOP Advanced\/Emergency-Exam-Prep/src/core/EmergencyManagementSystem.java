package core;

import collection.EmergencyRegister;
import collection.Register;
import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmergencyManagementSystem implements ManagementSystem {

    private static final String PROPERTY = "Property";
    private static final String HEALTH = "Health";
    private static final String ORDER = "Order";
    private static final String FIRE = "Fire";
    private static final String MEDICAL = "Medical";
    private static final String POLICE = "Police";
    private static final long INITIAL_VALUE = 0L;
    private static final String REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_S_AT_S = "Registered Public %s Emergency of level %s at %s.";
    private static final String REGISTERED_SERVICE_EMERGENCY_CENTER_S = "Registered %s Service Emergency Center - %s.";

    private Map<String, Register<Emergency>> emergencies;
    private Map<String, Register<EmergencyCenter>> centers;
    private Map<String, Long> resultsOfProcessedEmergencies;
    private Integer totalProcessedEmergencies;

    public EmergencyManagementSystem() {
        this.initEmergenciesCollection();
        this.initCentersCollection();
        this.initResultsCollection();
        this.totalProcessedEmergencies = 0;
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.emergencies.get(PROPERTY).enqueueEmergency(emergency);
        return String.format(
                REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_S_AT_S,PROPERTY,
                emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.emergencies.get(HEALTH).enqueueEmergency(emergency);
        return String.format(
                REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_S_AT_S,HEALTH,
                emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.emergencies.get(ORDER).enqueueEmergency(emergency);
        return String.format(
                REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_S_AT_S,ORDER,
                emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter emergencyCenter) {
        this.centers.get(PROPERTY).enqueueEmergency(emergencyCenter);
        return String.format(
                REGISTERED_SERVICE_EMERGENCY_CENTER_S,FIRE,
                emergencyCenter.getName());
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter emergencyCenter) {
        this.centers.get(HEALTH).enqueueEmergency(emergencyCenter);
        return String.format(
                REGISTERED_SERVICE_EMERGENCY_CENTER_S,MEDICAL,
                emergencyCenter.getName());
    }

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter emergencyCenter) {
        this.centers.get(ORDER).enqueueEmergency(emergencyCenter);
        return String.format(
                REGISTERED_SERVICE_EMERGENCY_CENTER_S,POLICE,
                emergencyCenter.getName());
    }

    @Override
    public String processEmergencies(String type) {
        Register<Emergency> emergenciesToProcess = this.emergencies.get(type);
        Register<EmergencyCenter> processCenters = this.centers.get(type);

        while (!emergenciesToProcess.isEmpty()) {
            if (processCenters.isEmpty()) {
                return String.format(
                        "%s Emergencies left to process: %d.",
                        type, emergenciesToProcess.count());
            }
            EmergencyCenter currentCenter = processCenters.dequeueEmergency();
            if (currentCenter.isForRetirement()) {
                continue;
            }
            Emergency currentEmergency = emergenciesToProcess.dequeueEmergency();
            Long currentResult = this.resultsOfProcessedEmergencies.get(type);
            this.resultsOfProcessedEmergencies.put(
                    type, currentResult + currentEmergency.getResultAfterProcessing());
            currentCenter.processEmergency();
            processCenters.enqueueEmergency(currentCenter);
            this.totalProcessedEmergencies++;
        }
        return String.format(
                "Successfully responded to all %s emergencies.", type);
    }

    @Override
    public String emergencyReport() {
        for (Register<EmergencyCenter> centerRegister : this.centers.values()) {
            List<EmergencyCenter> temp = new LinkedList<>();
            while (!centerRegister.isEmpty()) {
                EmergencyCenter currentCenter = centerRegister.dequeueEmergency();
                if (currentCenter.isForRetirement()) {
                    continue;
                }
                temp.add(currentCenter);
            }
            for (EmergencyCenter emergencyCenter : temp) {
                centerRegister.enqueueEmergency(emergencyCenter);
            }
        }
        StringBuilder builder = new StringBuilder();
        Integer allRegisteredEmergencies = this.emergencies.entrySet().stream().
                mapToInt(currentEmergencies -> currentEmergencies.getValue().count()).sum();

        builder.append(String.format("PRRM Services Live Statistics%n"));
        builder.append(
                String.format("Fire Service Centers: %d%n", this.centers.get(PROPERTY).count()));
        builder.append(
                String.format("Medical Service Centers: %d%n", this.centers.get(HEALTH).count()));
        builder.append(
                String.format("Police Service Centers: %d%n", this.centers.get(ORDER).count()));
        builder.append(
                String.format("Total Processed Emergencies: %d%n", this.totalProcessedEmergencies));
        builder.append(
                String.format("Currently Registered Emergencies: %d%n", allRegisteredEmergencies));
        builder.append(String.format(
                "Total Property Damage Fixed: %d%n", this.resultsOfProcessedEmergencies.get(PROPERTY)));
        builder.append(String.format(
                "Total Health Casualties Saved: %d%n", this.resultsOfProcessedEmergencies.get(HEALTH)));
        builder.append(String.format(
                "Total Special Cases Processed: %d", this.resultsOfProcessedEmergencies.get(ORDER)));
        return builder.toString();
    }

    private void initCentersCollection() {
        this.centers = new HashMap<>();
        this.centers.put(PROPERTY, new EmergencyRegister<>());
        this.centers.put(HEALTH, new EmergencyRegister<>());
        this.centers.put(ORDER, new EmergencyRegister<>());
    }

    private void initEmergenciesCollection() {
        this.emergencies = new HashMap<>();
        this.emergencies.put(PROPERTY, new EmergencyRegister<>());
        this.emergencies.put(HEALTH, new EmergencyRegister<>());
        this.emergencies.put(ORDER, new EmergencyRegister<>());
    }

    private void initResultsCollection() {
        this.resultsOfProcessedEmergencies = new HashMap<>();
        this.resultsOfProcessedEmergencies.put(PROPERTY, INITIAL_VALUE);
        this.resultsOfProcessedEmergencies.put(HEALTH, INITIAL_VALUE);
        this.resultsOfProcessedEmergencies.put(ORDER, INITIAL_VALUE);
    }

}
