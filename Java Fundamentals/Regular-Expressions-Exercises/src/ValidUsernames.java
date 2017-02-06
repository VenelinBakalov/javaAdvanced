import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<=[ \\/\\\\()]|^)[a-zA-Z]\\w{2,24}(?=[ \\/\\\\()]|$)";
        Pattern pattern = Pattern.compile(regex);

        String text = reader.readLine();

        Matcher matcher = pattern.matcher(text);
        int longestSequenceLenght = Integer.MIN_VALUE;
        String previousMatch = "";
        String longestSequence = "";

        while (matcher.find()) {
            String match = matcher.group();
            int currentLenght = match.length() + previousMatch.length();

            if (currentLenght > longestSequenceLenght) {
                longestSequence = previousMatch + "\r\n" + match;
                longestSequenceLenght = currentLenght;
            }

            previousMatch = match;
        }

        System.out.println(longestSequence);
    }
}
