import contracts.BoatCreator;
import contracts.BoatSimulatorController;
import contracts.CommandHandler;
import contracts.EngineCreator;
import controllers.BoatSimulatorControllerImpl;
import core.BoatCreatorImpl;
import core.CommandHandlerImpl;
import core.Engine;
import core.EngineCreatorImpl;

public class Main {
    public static void main(String[] args) {
        BoatSimulatorController controller = new BoatSimulatorControllerImpl();
        BoatCreator boatCreator = new BoatCreatorImpl();
        EngineCreator engineCreator = new EngineCreatorImpl();
        CommandHandler commandHandler = new CommandHandlerImpl(controller, boatCreator, engineCreator);
        Engine engine = new Engine(commandHandler);

        engine.run();
    }
}
