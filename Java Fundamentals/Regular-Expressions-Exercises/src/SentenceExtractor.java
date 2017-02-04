import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();

        String regex = "(^| )[^!.?]*\\b" + word + "\\b.*?[.!?]";
        Pattern pattern = Pattern.compile(regex);

        String text = reader.readLine();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}
