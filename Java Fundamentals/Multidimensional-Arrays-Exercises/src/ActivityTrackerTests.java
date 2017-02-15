import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityTrackerTests {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int logsCount = Integer.parseInt(reader.readLine());

        // Date thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mystring);

        Map<Date, Map<String, Double>> activityByMonth = new LinkedHashMap<>();

        for (int i = 0; i < logsCount; i++) {
            String[] logInput = reader.readLine().split(" ");
            Date date = new SimpleDateFormat("MM/yyyy", Locale.ENGLISH).parse(logInput[0].substring(3));

            String user = logInput[1];
            double distance = Double.parseDouble(logInput[2]);

            activityByMonth.putIfAbsent(date, new LinkedHashMap<>());
            activityByMonth.get(date).putIfAbsent(user, 0D);
            activityByMonth.get(date).put(user, activityByMonth.get(date).get(user) + distance);
        }

        activityByMonth.entrySet().stream()
                .sorted((m1, m2) -> m1.getKey().compareTo(m2.getKey()))
                .forEach(month -> System.out.println((month.getKey().getMonth() + 1) + ": " +
                month.getValue().entrySet().stream()
                        .sorted((u1, u2) -> Double.compare(u2.getValue(), u1.getValue()))
                        .map(u -> String.format("%s(%.0f)",u.getKey(), u.getValue()))
                        .collect(Collectors.joining(", "))
                ));
    }
}
