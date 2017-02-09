import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^Grow <(?<region>[A-Z][a-z]+)> <(?<color>[a-zA-Z0-9]+)> (?<amount>[0-9]+)$";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Long>> regions = new HashMap<>();
        Map<String, Long> regionsByTotalAmount = new HashMap<>();

        String line = "";

        while (!"Icarus, Ignite!".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String region = matcher.group("region");
                String color = matcher.group("color");
                long amount = Long.parseLong(matcher.group("amount"));

                if (!regions.containsKey(region)) {
                    regions.put(region, new HashMap<>());
                }
                if (!regions.get(region).containsKey(color)) {
                    regions.get(region).put(color, 0L);
                }
                regions.get(region).put(color, regions.get(region).get(color) + amount);
            }
        }

        for (String region : regions.keySet()) {
            long totalAmount = 0;

            for (Long amount : regions.get(region).values()) {
                totalAmount += amount;
            }

            regionsByTotalAmount.put(region, totalAmount);
        }

        regionsByTotalAmount.entrySet().stream()
                .sorted((region1, region2) -> {
                    if (region2.getValue().compareTo(region1.getValue()) == 0) {
                        return region1.getKey().compareTo(region2.getKey());
                    }
                    return region2.getValue().compareTo(region1.getValue());
                })
                .forEach(region -> {
                    System.out.println(region.getKey());

                    regions.get(region.getKey()).entrySet().stream()
                            .sorted((color1, color2) -> {
                                if (Long.compare(color1.getValue(), color2.getValue()) == 0) {
                                    return color1.getKey().compareTo(color2.getKey());
                                }
                                return color1.getValue().compareTo(color2.getValue());
                            })
                            .forEach(color -> {
                                System.out.println("*--" + color.getKey() + " | " + color.getValue());
                            });
                });
    }
}
