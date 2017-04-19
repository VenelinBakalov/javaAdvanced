package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Burnable;

/**
 * Created by Venelin on 19.4.2017 г..
 */
@Burnable
public class BurnableGarbage extends BaseWaste {

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
