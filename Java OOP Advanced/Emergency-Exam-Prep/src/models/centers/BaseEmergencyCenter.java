package models.centers;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;

    private Integer amountOfMaximumEmergencies;

    private Integer proccessedEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.proccessedEmergencies = 0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfMaximumEmergencies() {
        return this.amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    public Boolean isForRetirement() {
        return this.proccessedEmergencies >= this.amountOfMaximumEmergencies;
    }
}
