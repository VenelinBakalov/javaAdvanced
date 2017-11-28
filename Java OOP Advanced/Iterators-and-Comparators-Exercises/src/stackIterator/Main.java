package stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Venelin on 22.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomStack stack = new CustomStack();
        String command;

        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(", | ");
            String commandType = commandArgs[0];

            try {
                switch (commandType) {
                    case "Push":
                        stack.push(Stream.of(commandArgs).skip(1).map(Integer::parseInt).toArray(Integer[]::new));
                        break;
                    case "Pop":
                        stack.pop();
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
