import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> tokens = Arrays.asList(reader.readLine().split(" "));

        OptionalInt sum = tokens.stream()
                .filter(FindAndSumIntegers::isNumber)
                .mapToInt(Integer::parseInt)
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String string) {

        if (string.isEmpty()) {
            return false;
        }

        char[] characters = string.toCharArray();

        for (int i = 0; i < characters.length; i++) {

            if (i == 0) {
                if (characters[i] == '+' || characters[i] == '-') {
                    continue;
                }
            }

            if (!Character.isDigit(characters[i])) {
                return false;
            }
        }

        return true;
    }
}
