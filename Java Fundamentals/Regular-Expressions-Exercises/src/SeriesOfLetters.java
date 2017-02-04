import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([a-zA-Z])\\1+";
        Pattern pattern = Pattern.compile(regex);

        String line = reader.readLine();
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            line = matcher.replaceAll("$1");
        }

        System.out.print(line);
    }
}
