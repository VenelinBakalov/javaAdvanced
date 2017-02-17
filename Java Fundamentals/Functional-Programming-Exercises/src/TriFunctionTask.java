import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriFunctionTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiFunction<String, Integer, Boolean> filter = (x, y) -> {
            int charSum = 0;

            for (char c : x.toCharArray()) {
                charSum += c;
            }

            return charSum >= y;
        };

        TriFunction<Integer, BiFunction<String, Integer, Boolean>, List<String>, String> triFunction = (number, biFunction, collection) -> {
            for (int i = 0; i < collection.size(); i++) {
                if (biFunction.apply(collection.get(i), number)) {
                    return collection.get(i);
                }
            }
            return null;
        };

        int filterNumber = Integer.parseInt(reader.readLine());
        List<String> names = Stream.of(reader.readLine().split(" ")).collect(Collectors.toList());
        String name = triFunction.apply(filterNumber, filter, names);

        if (name != null) {
            System.out.println(name);
        }
    }
}

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
