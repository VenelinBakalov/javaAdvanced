import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        List<Integer> numbers = new ArrayList<>();

        for (String number : input) {
            numbers.add(Integer.parseInt(number));
        }

        StringBuilder sb = new StringBuilder();

        numbers.removeIf(number -> number % 2 != 0);
        for (Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);

        numbers.sort((a, b) -> a.compareTo(b));
        List<String> sorted = new ArrayList<>();

        for (Integer number : numbers) {
            sorted.add(String.valueOf(number));
        }

        System.out.println(String.join(", ", sorted));

    }
}
