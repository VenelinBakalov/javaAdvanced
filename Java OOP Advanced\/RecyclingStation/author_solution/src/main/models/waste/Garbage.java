package main.models.waste;


import main.wasteDisposal.Contracts.Waste;

public abstract class Garbage implements Waste {

    private String name;
    private double weight;
    private double volumePerKg;

    protected Garbage(String name, double weight, double volumePerKg)
    {
        this.setName(name);
        this.setWeight(weight);
        this.setVolumePerKg(volumePerKg);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolumePerKg() {
        return volumePerKg;
    }

    private void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }


}
