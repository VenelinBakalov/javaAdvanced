package core;

import contracts.IBoatSimulatorController;
import contracts.CommandHandler;
import contracts.Race;
import database.BoatSimulatorDatabase;
import exeptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandlerImpl commandHandler;

    public Engine(CommandHandlerImpl commandHandler)
    {
        this.commandHandler = commandHandler;
    }

    public Engine()
    {
        this.commandHandler = new CommandHandlerImpl();
    }

    public CommandHandler getCommandHandler;

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
            public Race getCurrentRace() {
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

        CommandHandlerImpl commandHandler = new CommandHandlerImpl(ctrl);
        Engine engine = new Engine();
        engine.Run();
    }
}
