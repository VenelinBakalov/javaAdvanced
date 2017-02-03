import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "<a\\s*(.*?)?href\\s*=\\s*(('.+')|(\".+\")|([a-z\\/:.]+)).*>";
        Pattern pattern = Pattern.compile(regex);

        String htmlFragment = reader.readLine();

        while (!"END".equals(htmlFragment)) {
            Matcher matcher = pattern.matcher(htmlFragment);

            if (matcher.find()) {

            }
        }
    }
}
