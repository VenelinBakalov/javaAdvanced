import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int messageCount = Integer.parseInt(reader.readLine());

        StringBuilder input = new StringBuilder();

        for (int i = 0; i < messageCount; i++) {
            String message = reader.readLine();
            input.append(message);
        }

        String jediPattern = reader.readLine();
        String messagePattern = reader.readLine();
        String jediRegex = jediPattern + "([a-zA-Z]{" + jediPattern.length() + "})(?=[^a-zA-Z])";
        String messageRegex = messagePattern + "([a-zA-Z0-9]{" + messagePattern.length() + "})(?=[^a-zA-Z0-9])";
        Pattern jediRegexPattern = Pattern.compile(jediRegex);
        Pattern messageRegexPattern = Pattern.compile(messageRegex);

        List<String> jedi = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        Matcher jediMatcher = jediRegexPattern.matcher(input);
        while (jediMatcher.find()) {
            jedi.add(jediMatcher.group(1));
        }

        Matcher messageMatcher = messageRegexPattern.matcher(input);
        while (messageMatcher.find()) {
            messages.add(messageMatcher.group(1));
        }

        int[] indexes = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int jediIndex = 0;

        for (int i = 0; i < indexes.length; i++) {
            int messageIndex = indexes[i] - 1;

            if (messageIndex >= messages.size()) {
                continue;
            }
            if (jediIndex >= jedi.size()) {
                break;
            }
            System.out.println(String.format("%s - %s", jedi.get(jediIndex), messages.get(messageIndex)));
            jediIndex++;
        }


    }
}
