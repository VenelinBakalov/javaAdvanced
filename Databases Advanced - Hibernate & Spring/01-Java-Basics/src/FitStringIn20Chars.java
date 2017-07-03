import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Venelin on 3.7.2017 г..
 */
public class FitStringIn20Chars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String chars = reader.readLine();

        if (chars.length() < 20) {
//            chars = String.format("%-20s", chars).replace(' ', '*');
            String toAppend = new String(new char[20 - chars.length()]).replace('\0', '*');
            chars = chars + toAppend;
        } else {
            chars = chars.substring(0, 20);
        }


        System.out.println(chars);
    }
}
