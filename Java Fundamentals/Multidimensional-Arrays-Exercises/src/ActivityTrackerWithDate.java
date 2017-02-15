import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class ActivityTrackerWithDate {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int logsCount = Integer.parseInt(reader.readLine());

        Map<Integer, Map<String, Integer>> activityByMonth = new TreeMap<>();

        for (int i = 0; i < logsCount; i++) {
            String[] logInput = reader.readLine().split(" ");
            String[] date = logInput[0].split("\\/");
            int month = Integer.parseInt(date[1]);

            String user = logInput[1];
            int distance = Integer.parseInt(logInput[2]);

            activityByMonth.putIfAbsent(month, new TreeMap<>());
            activityByMonth.get(month).putIfAbsent(user, 0);
            activityByMonth.get(month).put(user, activityByMonth.get(month).get(user) + distance);
        }

         activityByMonth.entrySet()
                .forEach(month -> System.out.println(month.getKey() + ": " +
                        month.getValue().entrySet().stream()
                                .map(u -> String.format("%s(%d)",u.getKey(), u.getValue()))
                                .collect(Collectors.joining(", "))
                ));
    }
}
