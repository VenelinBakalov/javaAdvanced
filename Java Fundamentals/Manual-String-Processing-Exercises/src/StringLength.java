import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        if (input.length() > 20) {
            System.out.println(input.substring(0, 20));
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(input);
        String star = "*";

        stringBuilder.append(new String(new char[20 - input.length()]).replace("\0", star));
        System.out.println(stringBuilder);
    }
}
