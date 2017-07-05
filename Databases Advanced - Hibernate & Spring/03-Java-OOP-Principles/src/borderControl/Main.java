package borderControl;

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
        List<Identifiable> minions = new ArrayList<>();

        while (true) {
            String[] inputArgs = reader.readLine().split("\\s+");
            if ("End".equals(inputArgs[0])) break;

            Identifiable minion = null;

            if (inputArgs.length == 2) {
                minion = new Robot(inputArgs[0], inputArgs[1]);
            } else {
                minion = new Citizen(inputArgs[0], Integer.parseInt(inputArgs[1]), inputArgs[2]);
            }
            minions.add(minion);
        }

        String fakeIds = reader.readLine();

        minions.stream().filter(m -> m.isFake(fakeIds)).forEach(m -> {
            System.out.println(m.getId());
        });
    }
}
