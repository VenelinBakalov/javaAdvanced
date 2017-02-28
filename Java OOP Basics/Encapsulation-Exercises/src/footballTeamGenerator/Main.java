package footballTeamGenerator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();
        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] inputArgs = input.split(";");
            String commandType = inputArgs[0];
            String teamName = inputArgs[1];
            Team team = null;
            Player player = null;
            switch (commandType) {
                case "Team":
                    if (!teams.containsKey(teamName)) {
                        try {
                            team = new Team(teamName);
                            teams.put(teamName, team);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case "Add":
                    if (!teams.containsKey(teamName)) {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                        break;
                    }

                    String playerName = inputArgs[2];
                    int endurance = Integer.parseInt(inputArgs[3]);
                    int sprint = Integer.parseInt(inputArgs[4]);
                    int dribble = Integer.parseInt(inputArgs[5]);
                    int passing  = Integer.parseInt(inputArgs[6]);
                    int shooting = Integer.parseInt(inputArgs[7]);

                    team = teams.get(teamName);

                    try {
                        player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        team.addPlayer(player);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Remove":
                    if (!teams.containsKey(teamName)) {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                        break;
                    }

                    team = teams.get(teamName);
                    playerName = inputArgs[2];
                    try {
                        team.removePlayer(playerName);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teams.containsKey(teamName)) {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                        break;
                    }
                    team = teams.get(teamName);
                    System.out.println(team);
                    break;
            }
        }
    }
}
