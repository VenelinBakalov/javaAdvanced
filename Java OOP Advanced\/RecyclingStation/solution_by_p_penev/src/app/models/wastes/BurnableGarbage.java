package app.models.wastes;

import app.waste_disposal.annotations.Burnable;

@Burnable
public class BurnableGarbage extends AbstractGarbage {


    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
