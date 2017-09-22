package core;

import contracts.BoatEngine;
import contracts.EngineCreator;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.DuplicateModelException;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Venelin on 16.4.2017 г..
 */
public class EngineCreatorImpl implements EngineCreator {

    private BoatSimulatorDatabase database = BoatSimulatorDatabase.getInstance();

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }
}
