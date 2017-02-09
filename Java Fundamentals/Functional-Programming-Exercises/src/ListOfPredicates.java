import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int range = Integer.parseInt(reader.readLine());
        int[] divisors = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> result = new ArrayList<>();

        BiPredicate<Integer, Integer> isDivisible = (x, y) -> x % y == 0;
        BiPredicate<Integer, int[]> isDivisibleByArray = (x, y) -> {
            boolean divisible = true;

            for (int number : y) {
                if (!isDivisible.test(x, number)){
                    divisible = false;
                }
            }
            return divisible;
        };

        for (int i = 1; i <= range; i++) {
            if (isDivisibleByArray.test(i, divisors)) {
                result.add(i);
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
