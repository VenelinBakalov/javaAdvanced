package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> citySubjects = new ArrayList<>();
        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            Identifiable currentSubject = null;
            if (commandArgs.length == 3) {
                currentSubject = new Citizen(commandArgs[0], Integer.parseInt(commandArgs[1]), commandArgs[2]);
            } else {
                currentSubject = new Robot(commandArgs[0], commandArgs[1]);
            }

            citySubjects.add(currentSubject);
        }

        String fakeId = reader.readLine();

        citySubjects.stream().filter(c -> c.isFake(fakeId))
                .forEach(c -> System.out.println(c.getId()));

 //    for (Identifiable citySubject : citySubjects) {
 //        if (citySubject.isFake(fakeId)) {
 //            System.out.println(citySubject.getId());
 //        }
 //    }
    }
}
