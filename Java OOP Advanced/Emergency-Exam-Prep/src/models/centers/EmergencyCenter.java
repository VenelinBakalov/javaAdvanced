package models.centers;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public interface EmergencyCenter {

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Integer getProcessedEmergencies();

    void processEmergency();

    Boolean isForRetirement();
}
