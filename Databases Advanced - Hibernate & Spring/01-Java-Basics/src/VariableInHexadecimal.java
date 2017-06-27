import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class VariableInHexadecimal {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String hexNumber = reader.readLine();
        int number = Integer.parseInt(hexNumber, 16);

        System.out.println(number);
    }
}
