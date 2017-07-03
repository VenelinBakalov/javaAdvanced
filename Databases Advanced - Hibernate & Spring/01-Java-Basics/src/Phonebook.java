import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Venelin on 3.7.2017 г..
 */
public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phonebook = new TreeMap<>();
        String input;

        while (! "END".equals(input = reader.readLine())) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];
            String name;

            switch (command) {
                case "A":
                    name = commandArgs[1];
                    String number = commandArgs[2];
                    phonebook.put(name, number);
                    break;
                case "S":
                    name = commandArgs[1];
                    if (phonebook.containsKey(name)) {
                        System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
                    } else {
                        System.out.println(String.format("Contact %s does not exist.", name));
                    }
                    break;
                case "ListAll":
                    phonebook.entrySet().stream()
                            .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                            .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
//                    phonebook.entrySet().forEach(entry -> {
//                        System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
//                    });
                    break;
            }
        }
    }
}
