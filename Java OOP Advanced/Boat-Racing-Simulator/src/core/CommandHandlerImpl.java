package core;

import Utility.Constants;
import contracts.CommandHandler;
import contracts.IBoatSimulatorController;
import controllers.BoatSimulatorController;
import enumeration.EngineType;
import exeptions.*;

import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    public IBoatSimulatorController controller;

    public CommandHandlerImpl(IBoatSimulatorController controller) {
        this.setContrller(controller);
    }

    public CommandHandlerImpl() {
        this.setContrller(new BoatSimulatorController());
    }

    public IBoatSimulatorController getController() {
        return this.controller;
    }

    private void setContrller(IBoatSimulatorController controller) {
        this.controller = controller;
    }

    @Override
    public String executeCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                EngineType engineType;
                if (parameters[3].equals("Jet")) {
                    return this.getController().CreateBoatEngine(
                            parameters[0],
                            Integer.parseInt(parameters[1]),
                            Integer.parseInt(parameters[2]),
                            "Jet");
                } else if (parameters[3].equals("Sterndrive")) {
                    return this.getController().CreateBoatEngine(
                            parameters[0],
                            Integer.parseInt(parameters[1]),
                            Integer.parseInt(parameters[2]),
                            "Sterndrive");
                }

                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);

            case "CreateRowBoat":
                return this.getController().CreateRowBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]));
            case "CreateSailBoat":
                return this.getController().CreateSailBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]));
            case "CreatePowerBoat":
                return this.getController().CreatePowerBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        parameters[2],
                        parameters[3]);
            case "CreateYacht":
                return this.getController().CreateYacht(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        parameters[2],
                        Integer.parseInt(parameters[3]));
            case "OpenRace":
                return this.getController().OpenRace(
                        Integer.parseInt(parameters[0]),
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]),
                        Boolean.parseBoolean(parameters[3]));
            case "SignUpBoat":
                return this.getController().SignUpBoat(parameters[0]);
            case "StartRace":
                return this.getController().StartRace();
            case "GetStatistic":
                return this.getController().GetStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
