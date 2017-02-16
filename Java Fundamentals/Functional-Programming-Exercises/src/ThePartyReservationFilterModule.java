import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> partyList = Stream.of(reader.readLine().split(" ")).collect(Collectors.toList());
        List<Predicate> predicate = new ArrayList<>();

        String line;
        while (!"Print".equals(line = reader.readLine())) {
            String[] command = line.split(";");
            String addOrRemove = command[0].split(" ")[0];
            String filterType = command[1];
            String filterValue = command[2];
            switch (filterType) {
                case "Starts with":
                    Predicate<String> startFilter = n -> n.startsWith(filterValue);
                    break;
                case "Ends with":
                    Predicate<String> endFilter = n -> n.endsWith(filterValue);
                    break;
                case "Length":
                    Predicate<String> lenghtFilter = n -> n.length() == Integer.parseInt(filterType);
                    break;
                case "Contains":
                    Predicate<String> containsFilter = n -> n.contains(filterType);
            }
            switch (addOrRemove) {
                case "add":
            }
        }
    }
}
