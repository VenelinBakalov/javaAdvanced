import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class TheBiggestSmallestInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        String elementType = reader.readLine();

        Function<Integer[], Integer> getBiggestNumber = x -> {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < x.length; i++) {
                if (x[i] >= max) {
                    max = x[i];
                }
            }
            return max;
        };

        Function<Integer[], Integer> getSmallestNumber = x -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < x.length; i++) {
                if (x[i] <= min) {
                    min = x[i];
                }
            }
            return min;
        };

       // TriFunction<Integer, Integer, String, Integer>
    }
}
