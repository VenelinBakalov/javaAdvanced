import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayManipulator {
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = Stream.of(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command;

        while (!"end".equals(command = reader.readLine().toLowerCase())) {
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "exchange":
                    int index = Integer.parseInt(commandArgs[1]);
                    if (index < 0 || index >= numbers.size()) {
                        System.out.println("Invalid index");
                    } else {
                        exchangeList(index);
                    }
                    break;
                case "max":
                    printMaxElementIndex(commandArgs[1]);
                    break;
                case "min":
                    printMinElementIndex(commandArgs[1]);
                    break;
                case "first":
                    printFirstElements(commandArgs);
                    break;
                case "last":
                    printLastElements(commandArgs);
                    break;
            }
        }

        System.out.println(numbers);
    }

    private static void printLastElements(String[] commandArgs) {
        int count = Integer.parseInt(commandArgs[1]);
        if (count > numbers.size()) {
            System.out.println("Invalid count");
            return;
        }

        int remainder = commandArgs[2].equals("even") ? 0 : 1;
        List<Integer> filtered = new ArrayList<>();

        filtered.addAll(numbers);
        Collections.reverse(filtered);
        filtered = filtered.stream().filter(n -> Math.abs(n) % 2 == remainder).limit(count).collect(Collectors.toList());
        Collections.reverse(filtered);

        if (filtered.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println(filtered);
        }
    }

    private static void printFirstElements(String[] commandArgs) {
        int count = Integer.parseInt(commandArgs[1]);
        if (count > numbers.size()) {
            System.out.println("Invalid count");
            return;
        }

        int remainder = commandArgs[2].equals("even") ? 0 : 1;
        List<Integer> filtered = numbers.stream().filter(n -> Math.abs(n) % 2 == remainder).limit(count).collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println(filtered);
        }

    }

    private static void printMinElementIndex(String type) {
        int remainder = type.equals("even") ? 0 : 1;

        List<Integer> filtered = numbers.stream().filter(n -> Math.abs(n) % 2 == remainder).collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No matches");
        } else {
            int element = filtered.stream().min(Integer::compareTo).get();
            int index = filtered.lastIndexOf(element);
            System.out.println(index);
        }
    }

    private static void printMaxElementIndex(String evenOrOdd) {
        int remainder = evenOrOdd.equals("even") ? 0 : 1;

        List<Integer> filtered = numbers.stream().filter(n -> Math.abs(n) % 2 == remainder).collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No matches");
        } else {
            int element = filtered.stream().mapToInt(n -> n).max().getAsInt();
            int index = numbers.lastIndexOf(element);
            System.out.println(index);
        }

    }

    private static void exchangeList(int index) {
        List<Integer> subList = numbers.stream().skip(index + 1).collect(Collectors.toList());
        numbers = numbers.stream().limit(index + 1).collect(Collectors.toList());
        numbers.addAll(0, subList);
    }
}
