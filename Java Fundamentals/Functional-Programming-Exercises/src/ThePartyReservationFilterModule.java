import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> partyList = Stream.of(reader.readLine().split(" ")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicates = new HashMap<>();

        String line;
        while (!"Print".equals(line = reader.readLine())) {
            String[] command = line.split(";");
            String addOrRemove = command[0].split(" ")[0];
            String filterType = command[1];
            String filterValue = command[2];

            Predicate<String> filter = createFilter(filterType, filterValue);

            switch (addOrRemove) {
                case "Add":
                    predicates.put(filterType + filterValue, filter);
                    break;
                case "Remove":
                    predicates.remove(filterType + filterValue);
            }
        }

        partyList.stream().filter(predicates.values().stream()
                .reduce(Predicate::and)
                .orElse(x->true))
                .forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> createFilter(String filterType, String filterValue) {

        switch (filterType) {
            case "Starts with":
                return n -> !n.startsWith(filterValue);
            case "Ends with":
                return n -> !n.endsWith(filterValue);
            case "Length":
                return n -> n.length() != Integer.parseInt(filterValue);
            case "Contains":
                return n -> !n.contains(filterValue);
            default:
                return null;
        }
    }
}
