package pawIncExercises;

import pawIncExercises.models.AnimalCenterManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 8.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AnimalCenterManager manager = new AnimalCenterManager();
        String line = reader.readLine();

        while (!"Paw Paw Pawah".equals(line)) {
            String[] commandArgs = line.split(" \\| ");
            String commandType = commandArgs[0];
            switch (commandType) {
                case "RegisterCleansingCenter":
                    manager.registerCleansingCenter(commandArgs[1]);
                    break;
                case "RegisterAdoptionCenter":
                    manager.registerAdoptionCenter(commandArgs[1]);
                    break;
                case "RegisterCastrationCenter":
                    manager.registerCastrationCenter(commandArgs[1]);
                    break;
                case "RegisterDog":
                    manager.registerDog(commandArgs[1],
                            Integer.parseInt(commandArgs[2]),
                            Integer.parseInt(commandArgs[3]),
                            commandArgs[4]);
                    break;
                case "RegisterCat":
                    manager.registerCat(
                            commandArgs[1],
                            Integer.parseInt(commandArgs[2]),
                            Integer.parseInt(commandArgs[3]),
                            commandArgs[4]);
                    break;
                case "SendForCleansing":
                    manager.sendForCleansing(commandArgs[1], commandArgs[2]);
                    break;
                case "SendForCastration":
                    manager.sendForCastration(commandArgs[1], commandArgs[2]);
                    break;
                case "Cleanse":
                    manager.cleanse(commandArgs[1]);
                    break;
                case "Adopt":
                    manager.adopt(commandArgs[1]);
                    break;
                case "Castrate":
                    manager.castrate(commandArgs[1]);
                    break;
                case "CastrationStatistics":
                    manager.printCastrationStatistics();
                    break;
            }
            line = reader.readLine();
        }

        manager.printStatistics();
    }
}
