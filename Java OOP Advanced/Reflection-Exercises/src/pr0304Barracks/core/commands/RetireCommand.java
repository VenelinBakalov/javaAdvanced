package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Alias;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

/**
 * Created by Venelin on 29.3.2017 г..
 */
@Alias("retire")
public class RetireCommand extends Command {

    @Inject private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String unitType = super.getData()[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        String output = unitType + " retired!";
        return output;
    }
}
