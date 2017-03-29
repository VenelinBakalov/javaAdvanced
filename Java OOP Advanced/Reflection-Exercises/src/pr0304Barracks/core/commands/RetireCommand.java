package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public class RetireCommand extends Command {

    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String unitType = super.getData()[1];
        try {
            super.getRepository().removeUnit(unitType);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        String output = unitType + " retired!";
        return output;
    }
}
