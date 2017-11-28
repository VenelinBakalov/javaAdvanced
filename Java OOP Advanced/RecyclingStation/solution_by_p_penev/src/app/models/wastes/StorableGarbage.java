package app.models.wastes;

import app.waste_disposal.annotations.Storable;

@Storable
public class StorableGarbage extends AbstractGarbage {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
