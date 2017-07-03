import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 3.7.2017 г..
 */
public class CensorEmailAddress {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String email = reader.readLine();
        String text = reader.readLine();

        String[] emailSplit = email.split("@");
        String username = emailSplit[0];
        String replacement = new String(new char[username.length()]).replace('\0', '*') + '@' + emailSplit[1];

        text = text.replace(email, replacement);

        System.out.println(text);
    }
}
