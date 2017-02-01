import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    private static final String UPCASE = "<upcase>";
    private static final String UPCASE_CLOSE = "</upcase>";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input.contains(UPCASE)) {
            int indexOfUpcase = input.indexOf(UPCASE);
            int indexOfUpcaseClose = input.indexOf(UPCASE_CLOSE);

            String textSubstringed = input.substring(indexOfUpcase + UPCASE.length(), indexOfUpcaseClose);
            input = input.replace(UPCASE + textSubstringed + UPCASE_CLOSE, textSubstringed.toUpperCase());
        }

        System.out.println(input);

    }
}
