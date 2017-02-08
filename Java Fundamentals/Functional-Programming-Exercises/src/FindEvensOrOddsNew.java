import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvensOrOddsNew {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        String command = reader.readLine();

        Predicate<Integer> condition = getCondition(command);

        for (int i = lowerBound; i <= upperBound ; i++) {
            if (condition.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static Predicate<Integer> getCondition(String condition) {
        switch (condition) {
            case "odd":
                return x -> x % 2 != 0;
            case "even":
                return x -> x % 2 == 0;
            default:
                return null;
        }
    }
}
