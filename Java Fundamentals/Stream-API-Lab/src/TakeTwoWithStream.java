import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TakeTwoWithStream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<Integer> print = x -> System.out.print(x + " ");

        numbers.stream()
                .distinct()
                .filter(x -> 10 <= x && x <= 20)
                .limit(2)
                .forEach(print);
    }
}
