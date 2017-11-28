package app.models.wastes;

import app.waste_disposal.annotations.Toxic;

@Toxic
public class ToxicGarbage extends AbstractGarbage {

    protected ToxicGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
