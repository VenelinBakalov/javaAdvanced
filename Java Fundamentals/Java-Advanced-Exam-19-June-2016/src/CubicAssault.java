import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> regions = new HashMap<>();

        String[] input = reader.readLine().split(" -> ");

        while (!"Count em all".equals(input[0])) {
            String region = input[0];
            String meteorType = input[1];
            Long amount = Long.parseLong(input[2]);

            if (!regions.containsKey(region)) {
                Map<String, Long> meteors = new HashMap<>();
                meteors.put("Green", 0L);
                meteors.put("Red", 0L);
                meteors.put("Black", 0L);
                regions.put(region, meteors);

            }

            regions.get(region).put(meteorType, regions.get(region).get(meteorType) + amount);

            if (regions.get(region).get("Green") >= 1000000) {
                regions.get(region).put("Red", regions.get(region).get("Red") + regions.get(region).get("Green") / 1000000);
                regions.get(region).put("Green", regions.get(region).get("Green") % 1000000);
                regions.get(region).put("Green", regions.get(region).get("Green") % 1000000);
            }

            if (regions.get(region).get("Red") >= 1000000) {
                regions.get(region).put("Black", regions.get(region).get("Black") + regions.get(region).get("Red") / 1000000);
                regions.get(region).put("Red", regions.get(region).get("Red") % 1000000);
            }

            input = reader.readLine().split(" -> ");
        }

        regions.entrySet().stream()
                .sorted((r1, r2) -> {
                    if (Long.compare(
                            r2.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue(),
                            r1.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue()) == 0) {
                        if (Integer.compare(r1.getKey().length(), r2.getKey().length()) == 0) {
                            return r1.getKey().compareTo(r2.getKey());
                        }
                        return ((Integer) r1.getKey().length()).compareTo(r2.getKey().length());
                    }
                    return Long.compare(
                            r2.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue(),
                            r1.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue());
                })
                .forEach(r -> {
                    System.out.println(r.getKey());
                    r.getValue().entrySet().stream()
                            .sorted((m1, m2) -> {
                                if (Long.compare(m2.getValue(), m1.getValue()) == 0) {
                                    return m1.getKey().compareTo(m2.getKey());
                                }
                                return Long.compare(m2.getValue(), m1.getValue());
                            })
                            .forEach(m -> {
                                System.out.println("-> " + m.getKey() + " : " + m.getValue());
                            });
                });
    }
}