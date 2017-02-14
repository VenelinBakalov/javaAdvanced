import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        String input;

        while (!"report".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            Long population = Long.valueOf(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).putIfAbsent(city, 0L);
            countries.get(country).put(city, countries.get(country).get(city) + population);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> {
                    long totalPop1 = c1.getValue().values().stream().mapToLong(p -> p).sum();
                    long totalPop2 = c2.getValue().values().stream().mapToLong(p -> p).sum();

                    return Long.compare(totalPop2, totalPop1);})
                .forEach(e -> {
                    long totalPop = e.getValue().values().stream().mapToLong(p -> p).sum();
                    System.out.println(String.format("%s (total population: %s)", e.getKey(), totalPop));

                    e.getValue().entrySet().stream()
                            .sorted((c1, c2) -> Long.compare(c2.getValue(),c1.getValue()))
                            .forEach(c -> {
                                System.out.println(String.format("=>%s: %s", c.getKey(), c.getValue()));
                            });
                });
    }
}
