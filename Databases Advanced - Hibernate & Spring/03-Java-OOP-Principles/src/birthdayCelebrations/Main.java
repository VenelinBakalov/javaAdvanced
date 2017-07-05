package birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Birthable> citySubjects = new ArrayList<>();
        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\s+");
            Birthable currentSubject = null;
            String type = commandArgs[0];
            switch (type) {
                case "Citizen":
                    currentSubject = new Citizen(commandArgs[1], Integer.parseInt(commandArgs[2]), commandArgs[3], commandArgs[4]);
                    break;
                case "Pet":
                    currentSubject = new Pet(commandArgs[1], commandArgs[2]);
                    break;
                case "Robot":
                    continue;
            }

            citySubjects.add(currentSubject);
        }

        String year = reader.readLine();

        citySubjects.stream().filter(c -> c.wasBornInYear(year))
                .forEach(c -> System.out.println(c.getBirthdate()));
    }
}
