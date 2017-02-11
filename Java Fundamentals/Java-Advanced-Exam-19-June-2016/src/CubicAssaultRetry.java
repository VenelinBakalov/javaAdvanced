import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CubicAssaultRetry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> regions = new HashMap<>();

        String[] input = reader.readLine().split(" -> ");

        while (!"Count em all".equals(input[0])) {
            String region = input[0];
            String meteorType = input[1];
            Long amount = Long.parseLong(input[2]);

            regions.putIfAbsent(region, new HashMap<>());
            regions.get(region).putIfAbsent("Green", 0L);
            regions.get(region).putIfAbsent("Red", 0L);
            regions.get(region).putIfAbsent("Black", 0L);

            amount += regions.get(region).get(meteorType);
            switch (meteorType) {
                case "Green":
                    if (amount >= 1000000) {
                        amount -= 1000000;
                        regions.get(region).put("Red", regions.get(region).get("Red") + 1);
                    }
                    break;
                case "Red":
                    if (amount >= 1000000) {
                        amount -= 1000000;
                        regions.get(region).put("Black", regions.get(region).get("Black") + 1);
                    }
                    break;
            }
            regions.get(region).put(meteorType, amount);

            input = reader.readLine().split(" -> ");
        }


        regions.entrySet().stream()
                .sorted((r1, r2) -> {
                    if (Long.compare(
                            r2.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).mapToLong(Map.Entry::getValue).sum(),
                            r1.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).mapToLong(Map.Entry::getValue).sum()) == 0) {
                        if (((Integer) r1.getKey().length()).compareTo(r2.getKey().length()) == 0) {
                            return r1.getKey().compareTo(r2.getKey());
                        } else {
                            return ((Integer) r1.getKey().length()).compareTo(r2.getKey().length());
                        }
                    }
                    return Long.compare(
                            r2.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).mapToLong(Map.Entry::getValue).sum(),
                            r1.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).mapToLong(Map.Entry::getValue).sum());
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
