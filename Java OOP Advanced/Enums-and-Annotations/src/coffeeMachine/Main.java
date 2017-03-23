package coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine machine = new CoffeeMachine();
        String command;

        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            if (commandArgs.length == 1) {
                machine.insertCoin(commandArgs[0]);
            } else {
                machine.buyCoffee(commandArgs[0], commandArgs[1]);
            }
        }

        for (Coffee coffee : machine.coffeesSold()) {
            System.out.println(coffee);
        };
    }
}
