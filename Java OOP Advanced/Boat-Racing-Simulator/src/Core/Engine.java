package core;

import contracts.CommandHandler;

import java.util.Scanner;
import java.util.stream.Stream;

public class Engine {

    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (true) {
            if (line.equals("End")) {
                break;
            }

            String[] tokens = line.split("\\\\");
            String name = tokens[0];
            String[] parameters = new String[tokens.length - 1];
            System.arraycopy(tokens, 1, parameters, 0, parameters.length);

            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                System.out.println(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }
}
