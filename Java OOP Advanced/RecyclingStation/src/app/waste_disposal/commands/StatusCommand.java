package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.models.recyclingStation.RecyclingStation;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class StatusCommand implements Executable {

    @Inject private RecyclingStation recyclingStation;

    @Override
    public String execute() {
        return String.format("Energy: %.2f Capital: %.2f",
                this.recyclingStation.getEnergyBalance(),
                this.recyclingStation.getCapitalBalance());
    }
}
