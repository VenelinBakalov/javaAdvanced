import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> bounds = Stream.of(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        Stream.of(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(x -> Collections.min(bounds) <= x && x <= Collections.max(bounds))
                .forEach(x -> System.out.print(x + " "));
    }
}