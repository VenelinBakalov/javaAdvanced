import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Function<Integer[], Integer> getMinNumber = numbersArr -> {
            int minNumber = Integer.MAX_VALUE;

            for (Integer number : numbersArr) {
                if (minNumber > number) {
                    minNumber = number;
                }
            }

            return minNumber;
        };

        System.out.println(getMinNumber.apply(numbers));

    }
}
