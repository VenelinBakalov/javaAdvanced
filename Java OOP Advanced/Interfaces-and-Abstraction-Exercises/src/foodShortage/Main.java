package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Buyer> citySubjects = new HashMap<>();
        int peopleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] personArgs = reader.readLine().split(" ");
            Buyer buyer = null;
            if (personArgs.length == 4) {
                buyer = new Citizen(personArgs[0], Integer.parseInt(personArgs[1]), personArgs[2], personArgs[3]);
            } else {
                buyer = new Rebel(personArgs[0], Integer.parseInt(personArgs[1]), personArgs[2]);
            }
            citySubjects.put(personArgs[0], buyer);
        }

        String name;
        while (!"End".equals(name = reader.readLine())) {
            if (citySubjects.containsKey(name)) {
                citySubjects.get(name).buyFood();
            }
        }
        System.out.println(citySubjects.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
