import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guestList = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        String[] commandLine = reader.readLine().split(" ");

        while (!"Party!".equals(commandLine[0])) {
            String command = commandLine[0];
            Predicate<String> validate = getPredicate(commandLine);

            switch (command) {
                case "Remove":
                    guestList.removeIf(validate);
                    break;
                case "Double":
                    List<String> temp = new ArrayList<>();
                    guestList.forEach(guest -> {
                        if (validate.test(guest)) {
                            temp.add(guest);
                        }
                        temp.add(guest);
                    });
                    guestList = temp;
                    break;
            }

            commandLine = reader.readLine().split(" ");
        }

        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }
        System.out.println(String.join(", ", guestList) + " are going to the party!");
    }

    public static Predicate<String> getPredicate(String[] commandLine) {
        String command = commandLine[1];
        switch (command) {
            case "StartsWith":
                return x -> x.indexOf(commandLine[2]) == 0;
            case "EndsWith":
                return x -> x.lastIndexOf(commandLine[2]) == x.length() - commandLine[2].length();
            case "Length":
                return x -> x.length() == Integer.parseInt(commandLine[2]);
            default:
                return null;
        }
    }

}
