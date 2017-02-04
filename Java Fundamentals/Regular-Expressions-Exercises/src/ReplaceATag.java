import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)<\\/a>");

        StringBuilder sb = new StringBuilder("");

        String line = reader.readLine();

        while (!"END".equals(line)) {
            sb.append(line).append("\r\n");
            line = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb);

        int pos = 0;
        while (matcher.find(pos)) {
            int startMatch = matcher.start();
            int endMatch = matcher.end();
            String replacement= "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
            sb.replace(startMatch, endMatch, replacement);

            matcher = pattern.matcher(sb);
        }

        System.out.println(sb);
    }
}