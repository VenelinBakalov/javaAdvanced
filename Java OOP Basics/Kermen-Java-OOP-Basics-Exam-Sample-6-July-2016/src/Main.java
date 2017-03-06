import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        while (!"Democracy".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String[] commandTypeAndPeople = commandArgs[0].split("(|, |)");
            String type = commandTypeAndPeople[0];
            Home home = null;

            switch (type) {
                case "YoungCouple":
                //   home = createNewYoungCoupleHome(commandTypeAndPeople[1], commandTypeAndPeople[2]);
            }
        }
    }


}
