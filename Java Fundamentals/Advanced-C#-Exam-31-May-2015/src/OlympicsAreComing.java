import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class OlympicsAreComing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();

        String input;

        while (!"report".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s*\\|\\s*");

            String participant = tokens[0].trim();
            String country = tokens[1].trim();

            participant = String.join(" ", participant.split("\\s+"));
            country = String.join(" ", country.split("\\s+"));

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).putIfAbsent(participant, 0);
            countries.get(country).put(participant, countries.get(country).get(participant) + 1);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> {
                    int wins1 = c1.getValue().values().stream().mapToInt(w -> w).sum();
                    int wins2 = c2.getValue().values().stream().mapToInt(w -> w).sum();
                    return Integer.compare(wins2, wins1);})
                .forEach(country -> {
                    int participants = country.getValue().size();
                    int wins = country.getValue().values().stream().mapToInt(w -> w).sum();
                    System.out.println(String.format("%s (%s participants): %s wins", country.getKey(), participants, wins));
                });
    }
}
