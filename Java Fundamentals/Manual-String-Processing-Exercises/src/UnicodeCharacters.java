import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int codePoint = input.codePointAt(i);
            result.append("\\u").append(String.format("%04X", codePoint).toLowerCase());
        }

        System.out.println(result);
    }
}
