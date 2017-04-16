package core;

import utility.Constants;
import contracts.CommandHandler;
import contracts.BoatSimulatorController;
import controllers.BoatSimulatorControllerImpl;
import enumeration.EngineType;
import exeptions.*;

public class CommandHandlerImpl implements CommandHandler {

    public BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.setController(controller);
    }

    public CommandHandlerImpl() {
        this.setController(new BoatSimulatorControllerImpl());
    }

    public BoatSimulatorController getController() {
        return this.controller;
    }

    private void setController(BoatSimulatorController controller) {
        this.controller = controller;
    }

    @Override
    public String executeCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                try {
                    return this.getController().createBoatEngine( parameters[0],
                            Integer.parseInt(parameters[1]),
                            Integer.parseInt(parameters[2]),
                            EngineType.valueOf(parameters[3].toUpperCase()));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
                }

            case "CreateRowBoat":
                return this.getController().createRowBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        false,
                        Integer.parseInt(parameters[2]));
            case "CreateSailBoat":
                return this.getController().createSailBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        false,
                        Integer.parseInt(parameters[2]));
            case "CreatePowerBoat":
                return this.getController().createPowerBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        true,
                        parameters[2],
                        parameters[3]);
            case "CreateYacht":
                return this.getController().createYacht(
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
                return this.getController().signUpBoat(parameters[0]);
            case "StartRace":
                return this.getController().startRace();
            case "GetStatistic":
                return this.getController().getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
