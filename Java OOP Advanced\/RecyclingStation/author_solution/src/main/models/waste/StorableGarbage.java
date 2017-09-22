package main.models.waste;

import main.annotations.Storable;

@Storable
public class StorableGarbage extends Garbage {
    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
