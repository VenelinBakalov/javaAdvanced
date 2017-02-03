import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "<.+?>";

        Pattern pattern = Pattern.compile(regex);

        String line = reader.readLine();

        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

            line = reader.readLine();
        }
    }
}
