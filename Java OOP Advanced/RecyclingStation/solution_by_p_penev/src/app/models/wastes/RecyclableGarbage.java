package app.models.wastes;

import app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends AbstractGarbage {

    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
