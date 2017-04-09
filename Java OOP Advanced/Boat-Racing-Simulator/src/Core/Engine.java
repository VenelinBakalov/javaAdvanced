package Core;

import contracts.IBoatSimulatorController;
import contracts.ICommandHandler;
import contracts.IRace;
import database.BoatSimulatorDatabase;
import exeptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler)
    {
        this.commandHandler = commandHandler;
    }

    public Engine()
    {
        this.commandHandler = new CommandHandler();
    }

    public ICommandHandler getCommandHandler;

    public void Run()
    {
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String name = "";
            List<String> parameters = new ArrayList<>();

            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try
            {
                String commandResult = this.commandHandler.ExecuteCommand(name, parameters);
                System.out.println(commandResult);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        IBoatSimulatorController ctrl = new IBoatSimulatorController() {
            @Override
            public IRace getCurrentRace() {
                return null;
            }

            @Override
            public BoatSimulatorDatabase getDatabase() {
                return null;
            }

            @Override
            public String CreateBoatEngine(String model, int horsepower, int displacement, String engineType) {
                return null;
            }

            @Override
            public String CreateRowBoat(String model, int weight, int oars) throws DuplicateModelException {
                return null;
            }

            @Override
            public String CreateSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
                return null;
            }

            @Override
            public String CreatePowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
                return null;
            }

            @Override
            public String CreateYacht(String model, int weight, String engineModel, int cargoWeight) throws
                    NonExistantModelException, DuplicateModelException {
                return null;
            }

            @Override
            public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
                return null;
            }

            @Override
            public String SignUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
                return null;
            }

            @Override
            public String StartRace() throws InsufficientContestantsException, NoSetRaceException {
                return null;
            }

            @Override
            public String GetStatistic() {
                return null;
            }
        };

        CommandHandler commandHandler = new CommandHandler(ctrl);
        Engine engine = new Engine();
        engine.Run();
    }
}
