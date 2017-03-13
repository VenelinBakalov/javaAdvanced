package nfs.core;

import nfs.io.ConsoleInputReader;
import nfs.io.ConsoleOutputWriter;
import nfs.utilities.Constants;
import nfs.utilities.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private ConsoleInputReader inputReader;

    private ConsoleOutputWriter outputWriter;

    private InputParser inputParser;

    private CarManager carManager;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.carManager = new CarManager();
    }

    public void run() {
        String inputLine = Constants.EMPTY_STRING;

        while(!(inputLine = this.inputReader.readLine()).equals(Constants.INPUT_TERMINATING_COMMAND)) {
            ArrayList<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(ArrayList<String> commandParams) {
        String command = commandParams.remove(0);

        switch(command) {
            case "register":
                int registerId = Integer.parseInt(commandParams.get(0));
                String registerType = commandParams.get(1);

                String brand = commandParams.get(2);
                String model = commandParams.get(3);
                int yearOfProduction = Integer.parseInt(commandParams.get(4));

                int horsepower = Integer.parseInt(commandParams.get(5));
                int acceleration = Integer.parseInt(commandParams.get(6));
                int suspension = Integer.parseInt(commandParams.get(7));
                int durability = Integer.parseInt(commandParams.get(8));

                this.carManager.register(registerId, registerType , brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "check":
                int checkId = Integer.parseInt(commandParams.get(0));

                this.outputWriter.writeLine(this.carManager.check(checkId));
                break;
            case "open":
                int openId = Integer.parseInt(commandParams.get(0));
                String openType = commandParams.get(1);

                int length = Integer.parseInt(commandParams.get(2));
                String route = commandParams.get(3);
                int prizePool = Integer.parseInt(commandParams.get(4));

                if(commandParams.size() > 5) {
                    int specialRaceParameter = Integer.parseInt(commandParams.get(5));
                    this.carManager.open(openId, openType, length, route, prizePool, specialRaceParameter);
                } else {
                    this.carManager.open(openId, openType, length, route, prizePool);
                }

                break;
            case "participate":
                int carId = Integer.parseInt(commandParams.get(0));
                int raceId = Integer.parseInt(commandParams.get(1));

                this.carManager.participate(carId, raceId);
                break;
            case "start":
                int startId = Integer.parseInt(commandParams.get(0));

                this.outputWriter.writeLine(this.carManager.start(startId));
                break;
            case "park":
                int parkId = Integer.parseInt(commandParams.get(0));

                this.carManager.park(parkId);
                break;
            case "unpark":
                int unparkId = Integer.parseInt(commandParams.get(0));

                this.carManager.unpark(unparkId);
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(commandParams.get(0));
                String addOn = commandParams.get(1);

                this.carManager.tune(tuneIndex, addOn);
                break;
        }
    }
}
