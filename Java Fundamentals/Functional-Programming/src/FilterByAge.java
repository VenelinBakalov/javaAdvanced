import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] inputLine = reader.readLine().split(", ");
            String name = inputLine[0];
            Integer age = Integer.parseInt(inputLine[1]);

            people.put(name, age);
        }

        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = createTester(condition, ageLimit);

        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudents(people, tester, printer);

    }

    private static void printFilteredStudents( LinkedHashMap<String, Integer> people,
                                               Predicate<Integer> tester,
                                               Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(person.getValue())) {
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter (String format) {
        switch (format) {
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            default:
                return null;
        }
    }

    private static Predicate<Integer> createTester (String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x <= age;
            case "older":
                return x -> x >= age;
            default:
                return null;
        }
    }
}
