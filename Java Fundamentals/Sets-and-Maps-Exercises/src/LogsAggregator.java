import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> userLogs = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] logInformation = scanner.nextLine().split(" ");
            String ip = logInformation[0];
            String user = logInformation[1];
            int duration = Integer.parseInt(logInformation[2]);

            insertUser(userLogs, user);
            insertLogInfo(userLogs, user, ip, duration);
        }

        TreeMap<String, Integer> userLogsTotalDuration = new TreeMap<>();

        for (String user : userLogs.keySet()) {
            int totalDuration = 0;
            for (Integer duration : userLogs.get(user).values()) {
                totalDuration += duration;
            }
            userLogsTotalDuration.put(user, totalDuration);
        }

        userLogsTotalDuration.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue() +
                    " [" + String.join(", ", userLogs.get(entry.getKey()).keySet()) + "]");
        });

        //    for (String user : userLogsTotalDuration.keySet()) {
        //        System.out.println(user + ": " + userLogsTotalDuration.get(user) +
        //        " [" + String.join(", ", userLogs.get(user).keySet()) + "]");
        //    }

    }

    private static void insertLogInfo(TreeMap<String, TreeMap<String, Integer>> userLogs, String user, String ip, int duration) {
        if (!userLogs.get(user).containsKey(ip)) {
            userLogs.get(user).put(ip, 0);
        }
        userLogs.get(user).put(ip, userLogs.get(user).get(ip) + duration);
    }

    private static void insertUser(TreeMap<String, TreeMap<String, Integer>> userLogs, String user) {
        if (!userLogs.containsKey(user)) {
            userLogs.put(user, new TreeMap<>());
        }
    }
}
