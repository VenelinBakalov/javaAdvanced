import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TheBiggestSmallestInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String elementType = reader.readLine();

        Function<List<Integer>, Integer> getBiggestNumber = x -> {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) >= max) {
                    max = x.get(i);
                }
            }
            return max;
        };

        Function<List<Integer>, Integer> getSmallestNumber = x -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) <= min) {
                    min = x.get(i);
                }
            }
            return min;
        };

        BiFunction<Function<List<Integer>, Integer>, Function<List<Integer>, Integer>, Integer> function = (a, b) -> {
            String smallestOrBiggest;
            Function<List<Integer>, Integer> func;
            if (elementType.contains("min")) {
                func = a;
            } else {
                func = b;
            }

            String evenOrOdd;
            if (elementType.contains("Even")) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }

            Predicate<Integer> filter = getFilter(evenOrOdd);
            List<Integer> result = new ArrayList<>();
            result = numbers.stream().filter(filter).collect(Collectors.toList());
            if (result.isEmpty()) {
                return null;
            }
            return func.apply(result);
        };

        Integer res = function.apply(getSmallestNumber, getBiggestNumber);
        if (res != null) {
            System.out.println(res);
        }
    }


    public static Predicate<Integer> getFilter (String evenOrOdd) {
        switch (evenOrOdd) {
            case "even":
                return x -> x % 2 == 0;
            case "odd":
                return x -> x % 2 != 0;
                default:
                    return null;

        }
    }
}
