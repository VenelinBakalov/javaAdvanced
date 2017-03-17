package customList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 17.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandInterpreter commandInterpreter = new CommandInterpreter();
        String command;
        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            commandInterpreter.readCommand(commandArgs);
        }
    }
}
