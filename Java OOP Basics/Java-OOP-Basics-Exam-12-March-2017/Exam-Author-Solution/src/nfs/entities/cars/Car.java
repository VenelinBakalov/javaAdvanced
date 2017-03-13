package nfs.entities.cars;

import nfs.utilities.Constants;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;

    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);

        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    protected void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    protected void setDurability(int durability) {
        this.durability = durability;
    }

    public int getEnginePerformance() {
        int enginePerformance = this.getHorsepower() / this.getAcceleration();

        return enginePerformance;
    }

    public int getSuspensionPerformance() {
        int suspensionPerformance = this.getSuspension() + this.getDurability();

        return suspensionPerformance;
    }

    public int getOverallPerformance() {
        int overallPerformance = getEnginePerformance() + getSuspensionPerformance();

        return overallPerformance;
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        this.setHorsepower(this.getHorsepower() + tuneIndex);
        this.setSuspension(this.getSuspension() + (tuneIndex / Constants.TUNING_SUSPENSION_MODIFIER));
    }

    public void breakDown(int lapLength) {
        this.setDurability(this.getDurability() - lapLength);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s %s %d\r\n", this.getBrand(), this.getModel(), this.getYearOfProduction()));
        result.append(String.format("%d HP, 100 m/h in %d s\r\n", this.getHorsepower(), this.getAcceleration()));
        result.append(String.format("%d Suspension force, %d Durability\r\n", this.getSuspension(), this.getDurability()));

        return result.toString();
    }
}
