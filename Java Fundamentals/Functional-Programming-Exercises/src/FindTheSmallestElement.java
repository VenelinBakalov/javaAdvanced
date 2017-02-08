import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getIndexOfSmallestElement = x -> {
            int minValue = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < x.length; i++) {
                if (x[i] <= minValue) {
                    minValue = x[i];
                    index = i;
                }
            }

            return index;
        };

        Consumer<Integer> printResult = x -> System.out.println(x);

        printResult.accept(getIndexOfSmallestElement.apply(numbers));
    }
}
