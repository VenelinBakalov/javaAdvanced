import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] gems = Stream.of(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Map<String, BiPredicate<Integer, Integer[]>> predicates = new HashMap<>();

        String command;
        while (!"Forge".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(";");
            String commandType = commandArgs[0];
            String sumType = commandArgs[1];
            int exclusionSum = Integer.parseInt(commandArgs[2]);

            switch (commandType) {
                case "Exclude":
                    BiPredicate<Integer, Integer[]> filter = createFilter(sumType, exclusionSum);
                    predicates.put(sumType + exclusionSum, filter);
                    break;

                case "Reverse":
                    predicates.remove(sumType + exclusionSum);
            }
        }
        List<String> gemsResults = new ArrayList<>();

        BiPredicate<Integer, Integer[]> filter = predicates.values().stream()
                .reduce(BiPredicate::and)
                .orElse((x, y) -> true);

        for (int i = 0; i < gems.length; i++) {
            if (filter.test(i, gems)) {
                gemsResults.add(String.valueOf(gems[i]));
            }
        }

        System.out.println(String.join(" ", gemsResults));
    }

    private static BiPredicate<Integer, Integer[]> createFilter(String sumType, int exclusionSum) {
        switch (sumType) {
            case "Sum Left":
                return (i, a) -> {
                    int currentNum = a[i];
                    int leftNum;
                    if (i - 1 < 0) {
                        leftNum = 0;
                    } else {
                        leftNum = a[i - 1];
                    }

                    return currentNum + leftNum != exclusionSum;
                };
            case "Sum Right":
                return (i, a) -> {
                    int currentNum = a[i];
                    int rightNum;
                    if (i + 1 >= a.length) {
                        rightNum = 0;
                    } else {
                        rightNum = a[i + 1];
                    }
                    return currentNum + rightNum != exclusionSum;
                };

            case "Sum Left Right":
                return (i, a) -> {
                    int currentNum = a[i];
                    int leftNum;
                    if (i - 1 < 0) {
                        leftNum = 0;
                    } else {
                        leftNum = a[i - 1];
                    }
                    int rightNum;
                    if (i + 1 >= a.length) {
                        rightNum = 0;
                    } else {
                        rightNum = a[i + 1];
                    }
                    return currentNum + leftNum + rightNum != exclusionSum;
                };

            default:
                return null;
        }
    }
}
