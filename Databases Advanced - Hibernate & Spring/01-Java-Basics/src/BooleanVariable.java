import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class BooleanVariable {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = Boolean.parseBoolean(reader.readLine());

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
