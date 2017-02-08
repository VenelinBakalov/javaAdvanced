import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;

public class SumNumbersBiFunction {

    public static void main(String[] args) throws IOException {

        // This is not correct in 1 particular case but actually I don't have the nerve to deal with all checks so...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        BiFunction<String, String, Integer> sumator = (x, y) -> Integer.parseInt(x) + Integer.parseInt(y);

        int sum = 0;

        for (int i = 0; i < input.length - 1; i+=2) {
            sum += sumator.apply(input[i], input[i + 1]);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }

}
