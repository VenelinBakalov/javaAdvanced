package core;

import contracts.BoatCreator;
import contracts.EngineCreator;
import database.BoatSimulatorDatabase;
import models.boats.Boat;
import utility.Constants;
import contracts.CommandHandler;
import contracts.BoatSimulatorController;
import controllers.BoatSimulatorControllerImpl;
import enumeration.EngineType;
import exeptions.*;

public class CommandHandlerImpl implements CommandHandler {

    private BoatSimulatorController controller;
    private BoatCreator boatCreator;
    private EngineCreator engineCreator;
    private BoatSimulatorDatabase database = BoatSimulatorDatabase.getInstance();

    public CommandHandlerImpl(BoatSimulatorController controller, BoatCreator boatCreator, EngineCreator engineCreator) {
        this.setController(controller);
        this.boatCreator = boatCreator;
        this.engineCreator = engineCreator;
    }

    public BoatSimulatorController getController() {
        return this.controller;
    }

    private void setController(BoatSimulatorController controller) {
        this.controller = controller;
    }

    @Override
    public String executeCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        Boat boat = null;

        try {
            switch (name) {
                case "CreateBoatEngine":
                    try {
                        return this.engineCreator.createBoatEngine(parameters[0],
                                Integer.parseInt(parameters[1]),
                                Integer.parseInt(parameters[2]),
                                EngineType.valueOf(parameters[3].toUpperCase()));
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
                    }

                case "CreateRowBoat":
                    boat = this.boatCreator.createRowBoat(
                            parameters[0],
                            Integer.parseInt(parameters[1]),
                            false,
                            Integer.parseInt(parameters[2]));
                case "CreateSailBoat":
                    boat = this.boatCreator.createSailBoat(
                            parameters[0],
                            Integer.parseInt(parameters[1]),
                            false,
                            Integer.parseInt(parameters[2]));
                case "CreatePowerBoat":
                    boat = this.boatCreator.createPowerBoat(
                            parameters[0],
                            Integer.parseInt(parameters[1]),
                            true,
                            parameters[2],
                            parameters[3]);
                case "CreateYacht":
                    boat = this.boatCreator.createYacht(
                            parameters[0],
                            Integer.parseInt(parameters[1]),
                            true,
                            parameters[2],
                            Integer.parseInt(parameters[3]));
                case "OpenRace":
                    return this.getController().openRace(
                            Integer.parseInt(parameters[0]),
                            Integer.parseInt(parameters[1]),
                            Integer.parseInt(parameters[2]),
                            Boolean.parseBoolean(parameters[3]));
                case "SignUpBoat":
                    return this.getController().signUpBoat(this.database.getBoats().getItem(parameters[0]));
                case "StartRace":
                    return this.getController().startRace();
                case "GetStatistic":
                    return this.getController().getStatistic();
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } finally {
            if (boat != null) {
                return this.getController().create(boat);
            }
        }
    }
}
