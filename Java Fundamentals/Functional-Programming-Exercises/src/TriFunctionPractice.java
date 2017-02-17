import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriFunctionPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TriFunctionCustom<Integer, BiFunction<String, Integer, Boolean>, List<String>, String> getName = (limit, filterFunc, names) -> {
            for (String name : names) {
                if (filterFunc.apply(name, limit)) {
                    return name;
                }
            }
            return null;
        };

        BiFunction<String, Integer, Boolean> filter = (name, limit) -> {
            int charSum = 0;

            for (char c : name.toCharArray()) {
                charSum += c;
            }

            return charSum >= limit;
        };

        int limitNum = Integer.parseInt(reader.readLine());
        List<String> names = Stream.of(reader.readLine().split(" ")).collect(Collectors.toList());

        String name = getName.apply(limitNum, filter, names);
        if (name != null) {
            System.out.println(name);
        }
    }
}

interface TriFunctionCustom <T, U, V, R> {
    R apply(T t, U u, V v);
}
