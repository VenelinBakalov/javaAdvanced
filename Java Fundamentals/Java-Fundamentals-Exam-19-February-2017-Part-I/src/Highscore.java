import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> players = new LinkedHashMap<>();
        Map<String, List<String>> playerDuels = new LinkedHashMap<>();
        String regex = "([0-9]+)\\s+([a-zA-Z0-9]+)\\s*<->\\s*([a-zA-Z0-9]+)\\s+([0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String input;
        while (!"osu!".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String firstPlayer = matcher.group(2);
                Long firstPlayerScore = Long.parseLong(matcher.group(1));
                String secondPlayer = matcher.group(3);
                Long secondPlayerScore = Long.parseLong(matcher.group(4));

                players.putIfAbsent(firstPlayer, 0L);
                players.putIfAbsent(secondPlayer, 0L);

                Long difference = firstPlayerScore - secondPlayerScore;

                if (difference > 0) {
                    players.put(firstPlayer, players.get(firstPlayer) + difference);
                    players.put(secondPlayer, players.get(secondPlayer) - difference);
                } else if (difference < 0) {
                    players.put(secondPlayer, players.get(secondPlayer) + Math.abs(difference));
                    players.put(firstPlayer, players.get(firstPlayer) - Math.abs(difference));
                }

                playerDuels.putIfAbsent(firstPlayer, new ArrayList<>());
                playerDuels.putIfAbsent(secondPlayer, new ArrayList<>());

                playerDuels.get(firstPlayer).add(String.format("*   %s <-> %s", secondPlayer, difference));
                playerDuels.get(secondPlayer).add(String.format("*   %s <-> %s", firstPlayer, -difference));
            }
        }


        players.entrySet().stream()
                .sorted((p1, p2) -> Long.compare(p2.getValue(), p1.getValue()))
                .forEach(player -> {
                    System.out.println(String.format("%s - (%s)", player.getKey(), player.getValue()));

                    for (String playerDuel : playerDuels.get(player.getKey())) {
                        System.out.println(playerDuel);
                    }
                });

    }
}
