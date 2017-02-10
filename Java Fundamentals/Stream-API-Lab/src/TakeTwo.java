import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Integer[] numbers = new Integer[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        Set<Integer> result = new LinkedHashSet<>();

        for (Integer number : numbers) {
            if (result.size() >= 2) {
                break;
            }

            if (number >= 10 && number <= 20) {
                result.add(number);
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
