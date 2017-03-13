package needForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 12.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        CarManager manager = new CarManager();

        while (!"Cops Are Here".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "register":
                    manager.register(Integer.parseInt(commandArgs[1]),
                            commandArgs[2],
                            commandArgs[3],
                            commandArgs[4],
                            Integer.parseInt(commandArgs[5]),
                            Integer.parseInt(commandArgs[6]),
                            Integer.parseInt(commandArgs[7]),
                            Integer.parseInt(commandArgs[8]),
                            Integer.parseInt(commandArgs[9])
                    );
                    break;
                case "check":
                    System.out.println(manager.check(Integer.parseInt(commandArgs[1])));
                    break;
                case "open":
                    if (commandArgs.length == 6) {
                        manager.open(Integer.parseInt(commandArgs[1]),
                                commandArgs[2],
                                Integer.parseInt(commandArgs[3]),
                                commandArgs[4],
                                Integer.parseInt(commandArgs[5]));
                    } else {
                        manager.open(Integer.parseInt(commandArgs[1]),
                                commandArgs[2],
                                Integer.parseInt(commandArgs[3]),
                                commandArgs[4],
                                Integer.parseInt(commandArgs[5]),
                                commandArgs.length == 7 ? Integer.parseInt(commandArgs[6]) : 0
                        );
                    }
                    break;
                case "participate":
                    manager.participate(Integer.parseInt(commandArgs[1]),
                            Integer.parseInt(commandArgs[2])
                    );
                    break;
                case "start":
                    System.out.println(manager.start(Integer.parseInt(commandArgs[1])));
                    break;
                case "park":
                    manager.park(Integer.parseInt(commandArgs[1]));
                    break;
                case "unpark":
                    manager.unpark(Integer.parseInt(commandArgs[1]));
                    break;
                case "tune":
                    manager.tune(Integer.parseInt(commandArgs[1]),
                            commandArgs[2]
                    );
                    break;
            }
        }
    }
}
