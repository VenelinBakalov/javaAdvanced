import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();

        String line;

        while (!"---NMS SEND---".equals(line = reader.readLine())){
            input.append(line);
        }

        String delimiter = reader.readLine();

        StringBuilder currentWord = new StringBuilder();

        currentWord.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char first = input.charAt(i - 1);
            char second = input.charAt(i);

            if (Character.toLowerCase(second) >= Character.toLowerCase(first)) {
                currentWord.append(second);
            } else {
                System.out.print(currentWord.append(delimiter));
                currentWord = new StringBuilder(String.valueOf(second));
            }
        }

        System.out.print(currentWord);

    }
}
