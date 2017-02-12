package IO;

import StaticData.SessionData;

import java.io.IOException;
import java.util.Scanner;

public class InputReader {

    private static final String END_COMMAND = "quit";

    public static void readCommands() throws IOException {

        OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        while (!END_COMMAND.equals(input)) {

            CommandInterpreter.interpretCommand(input);

            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
            input = scanner.nextLine().trim();
        }
    }
}
