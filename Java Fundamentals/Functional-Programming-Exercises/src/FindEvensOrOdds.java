import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        String command = reader.readLine();

        Predicate<Integer> findOddNumbers = x -> x % 2 != 0;
        Predicate<Integer> findEvenNumbers = x -> x % 2 == 0;

        List<Integer> result = new ArrayList<>();

        switch (command) {
            case "odd": findNumbers(result, findOddNumbers, lowerBound, upperBound); break;
            case "even": findNumbers(result, findEvenNumbers, lowerBound, upperBound); break;
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }

    private static void findNumbers(List<Integer> result, Predicate<Integer> findTypeNumbers, int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (findTypeNumbers.test(i)) {
                result.add(i);
            }
        }
    }


}
