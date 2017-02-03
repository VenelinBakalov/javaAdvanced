import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[a-zA-Z0-9\\-_]{3,16}$";

        String username = reader.readLine();

        while (!"END".equals(username)) {
            if (Pattern.matches(regex, username)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            username = reader.readLine();
        }

    }
}
