import contracts.BoatSimulatorController;
import contracts.CommandHandler;
import controllers.BoatSimulatorControllerImpl;
import core.CommandHandlerImpl;
import core.Engine;

public class Main {
    public static void main(String[] args) {
        BoatSimulatorController controller = new BoatSimulatorControllerImpl();
        CommandHandler commandHandler = new CommandHandlerImpl(controller);
        Engine engine = new Engine(commandHandler);

        engine.run();
    }
}
