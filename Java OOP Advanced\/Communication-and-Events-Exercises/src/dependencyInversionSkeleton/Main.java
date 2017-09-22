package dependencyInversionSkeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        PrimitiveCalculator calculator = new PrimitiveCalculator();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");

            if ("mode".equals(commandArgs[0])) {
                calculator.changeStrategy(commandArgs[1].charAt(0));
            } else {
                System.out.println(calculator.performCalculation(
                        Integer.parseInt(commandArgs[0]),
                        Integer.parseInt(commandArgs[1])
                ));
            }
        }
    }
}
