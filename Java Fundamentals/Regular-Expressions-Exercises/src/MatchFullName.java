import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        String name = reader.readLine();

        while (!"end".equals(name)) {

            if (Pattern.matches(regex, name)) {
                System.out.println(name);
            }

            name = reader.readLine();
        }
    }
}
