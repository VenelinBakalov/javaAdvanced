import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        // .map(..).collect(Collectors.toList())
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int divisor = Integer.parseInt(reader.readLine());

        Function<List<Integer>, List<Integer>> reverse = x -> {
            List<Integer> reversed = new ArrayList<>();

            for (int i = x.size() - 1; i >= 0; i--) {
                reversed.add(x.get(i));
            }

            return reversed;
        };

        List<Integer> reversed = reverse.apply(numbers);
        reversed.removeIf(x -> x % divisor == 0);

        for (Integer integer : reversed) {
            System.out.print(integer + " ");
        }

    }
}
