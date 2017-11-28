package kingsGambit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 13.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String kingName = reader.readLine();
        King king = new King(kingName);

        String[] royalGuards = reader.readLine().split(" ");
        String[] footmen = reader.readLine().split(" ");

        for (String royalGuard : royalGuards) {
            Defender guard = new RoyalGuard(royalGuard);
            king.addDefender(guard);
        }

        for (String footmanString : footmen) {
            Defender footman = new Footman(footmanString);
            king.addDefender(footman);
        }

        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String commandName = commandArgs[0];
            switch (commandName) {
                case "Attack":
                    king.respondToAttack();
                    break;
                case "Kill":
                    king.killDefender(commandArgs[1]);
                    break;
            }
        }
    }
}
