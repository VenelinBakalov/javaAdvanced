package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Storable;

/**
 * Created by Venelin on 19.4.2017 г..
 */
@Storable
public class StorableGarbage extends BaseWaste {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
