import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> venues = new LinkedHashMap<>();

        String regex = "^(?<singer>\\w+(\\s\\w+)*?) @(?<venue>\\w+(\\s\\w+)*?)\\s(?<price>\\d+)\\s(?<count>\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String venue = matcher.group("venue");
                String singer = matcher.group("singer");
                int ticketPrice = Integer.parseInt(matcher.group("price"));
                long ticketCount = Long.parseLong(matcher.group("count"));
                long profit = ticketCount * ticketPrice;

                insertVenue(venues, venue);
                insertSingerAndProfit(venues, venue, singer, profit);
            }

            input = scanner.nextLine();
        }

        for (String venue : venues.keySet()) {
            System.out.println(venue);

            venues.get(venue).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(((a, b) -> b.compareTo(a))))
                    .forEach(entry -> {
                        System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue());
                    });
        }
    }

    private static void insertSingerAndProfit(Map<String, LinkedHashMap<String, Long>> venues, String venue, String singer, long profit) {
        if (!venues.get(venue).containsKey(singer)) {
            venues.get(venue).put(singer, 0L);
        }
        venues.get(venue).put(singer, venues.get(venue).get(singer) + profit);
    }

    private static void insertVenue(Map<String, LinkedHashMap<String, Long>> venues, String venue) {
        if (!venues.containsKey(venue)) {
            venues.put(venue, new LinkedHashMap<>());
        }
    }
}


