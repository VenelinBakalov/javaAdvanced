package firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] info = reader.readLine().split(" ");
            String firstName = info[0];
            String lastName = info[1];
            int age = Integer.parseInt(info[2]);
            double salary = Double.parseDouble(info[3]);
            try {
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        Team team = new Team("Minior");

        people.forEach(team::addPlayer);
        System.out.println("First team have " + team.getFirstTeamPlayers().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeamPlayers().size() + " players");
    }
}
