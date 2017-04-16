package core;

import contracts.BoatCreator;
import contracts.BoatEngine;
import database.BoatSimulatorDatabase;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import models.boats.*;

/**
 * Created by Venelin on 16.4.2017 г..
 */
public class BoatCreatorImpl implements BoatCreator {

    private BoatSimulatorDatabase database = BoatSimulatorDatabase.getInstance();

    public Boat createRowBoat(String model, int weight, boolean isMotorBoat, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, isMotorBoat, oars);
        return boat;
    }

    public Boat createSailBoat(String model, int weight, boolean isMotorBoat, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, isMotorBoat, sailEfficiency);
        return boat;
    }

    public Boat createPowerBoat(String model, int weight, boolean isMotorBoat, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().getItem(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().getItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, isMotorBoat, firstEngine, secondEngine);
        return boat;
    }

    public Boat createYacht(String model, int weight, boolean isMotorBoat, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().getItem(engineModel);
        Boat boat = new Yacht(model, weight, isMotorBoat, engine, cargoWeight);
        return boat;
    }
}
