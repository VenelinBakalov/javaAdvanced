import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashMap<String, Long>> countries = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("\\|");

            if ("report".equals(input[0])) {
                break;
            }

            String city = input[0];
            String country = input[1];
            Long population = Long.parseLong(input[2]);

            insertCountry(countries, country);
            insertCity(countries, country, city, population);
        }

        Map<String, Long> countriesByPopulation = new LinkedHashMap<>();

        for (String country : countries.keySet()) {
            long totalPopulation = 0;
            for (Long populationCount : countries.get(country).values()) {
                totalPopulation += populationCount;
            }
            countriesByPopulation.put(country, totalPopulation);
        }

        Map<String, Long> countriesSorted = new LinkedHashMap<>();

        countriesByPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> countriesSorted.put(x.getKey(), x.getValue()));

        for (String country : countriesSorted.keySet()) {
            System.out.println(country + " (total population: " + countriesSorted.get(country) + ")");

            countries.get(country).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                    .forEach(entry -> {
                        System.out.println("=>" + entry.getKey() + ": " + entry.getValue());
                    });
        }

    }

    private static void insertCity(LinkedHashMap<String, HashMap<String, Long>> countries, String country, String city, Long population) {
        if (!countries.get(country).containsKey(city)) {
            countries.get(country).put(city, population);
        }
    }

    private static void insertCountry(LinkedHashMap<String, HashMap<String, Long>> countries, String country) {
        if (!countries.containsKey(country)) {
            countries.put(country, new LinkedHashMap<>());
        }
    }
}
