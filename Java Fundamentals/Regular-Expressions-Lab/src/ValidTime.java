import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$";
        Pattern pattern = Pattern.compile(regex);

        String time = reader.readLine();
        while (!"END".equals(time)) {
            Matcher matcher = pattern.matcher(time);

            if (matcher.find()) {
                if (isValidTime(matcher)) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid");
            }
            time = reader.readLine();
        }
    }

    private static boolean isValidTime(Matcher matcher) {
        int hour = Integer.parseInt(matcher.group(1));
        int minute = Integer.parseInt(matcher.group(2));
        int second = Integer.parseInt(matcher.group(3));

        if ( 1<= hour && hour <= 12 && minute < 60 && second < 60) {
            return true;
        }

        return false;
    }
}
