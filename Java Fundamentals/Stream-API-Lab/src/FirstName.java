import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));

        Set<Character> chars = new HashSet<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(s -> Character.toLowerCase(s.charAt(0)))
                .forEach(chars::add);

        Optional<String> firstName = names.stream()
                .filter(s -> chars.contains(Character.toLowerCase(s.charAt(0))))
                .sorted()
                .findFirst();

        if (firstName.isPresent()) {
            System.out.println(firstName.get());
        } else {
            System.out.println("No match");
        }

    }
}
