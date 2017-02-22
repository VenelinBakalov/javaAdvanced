package carSalesman;

public class Engine {

    private String model;
    private int power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }


    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:    %nPower: %d%n    Displacement: %s%n    Efficiency: %s",
                this.model, this.power, this.displacement, this.efficiency);
    }
}
