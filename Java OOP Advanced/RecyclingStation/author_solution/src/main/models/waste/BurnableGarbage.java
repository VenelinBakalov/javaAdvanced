package main.models.waste;


import main.annotations.Burnable;

@Burnable
public class BurnableGarbage extends Garbage{

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
