import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (true) {
            String command = scanner.nextLine();

            if ("end".equals(command)) {
                break;
            }

            String regex = "IP=(?<ip>[a-zA-Z0-9:.]+).+?\\'(?<message>[a-zA-Z&.!]*)\\'.*?=(?<username>.*)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);


            if (matcher.find()) {

                String userName = matcher.group("username");
                String ip = matcher.group("ip");

                insertUser(userLogs, userName);
                insertIp(userLogs, userName, ip);
            }

        }

        for (String user : userLogs.keySet()) {
            System.out.printf("%s:%n", user);
            ArrayList<String> output = new ArrayList<>();
            for (String ip : userLogs.get(user).keySet()) {
                output.add(ip + " => " + userLogs.get(user).get(ip));
            }
            System.out.println(String.join(", ", output) + ".");
        }
    }

    private static void insertIp(TreeMap<String, LinkedHashMap<String, Integer>> userLogs, String userName, String ip) {
        if (!userLogs.get(userName).containsKey(ip)) {
            userLogs.get(userName).put(ip, 0);
        }
        userLogs.get(userName).put(ip, userLogs.get(userName).get(ip) + 1);
    }

    private static void insertUser(TreeMap<String, LinkedHashMap<String, Integer>> userLogs, String username) {
        if (!userLogs.containsKey(username)) {
            userLogs.put(username, new LinkedHashMap<>());
        }
    }
}
