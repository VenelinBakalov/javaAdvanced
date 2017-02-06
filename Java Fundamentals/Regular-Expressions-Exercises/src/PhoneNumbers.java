import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<name>[A-Z][a-zA-Z]*)[^+a-zA-Z]*?(?<number>\\+?[\\d]+?([()\\/.\\- ]*[\\d]+)+)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, String> phonebook = new LinkedHashMap<>();

        StringBuilder sb = new StringBuilder();
        String inputLine = reader.readLine();

        while (!"END".equals(inputLine)) {
            sb.append(inputLine);
            inputLine = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            String name = matcher.group("name");
            String[] numberArgs = matcher.group("number").split("[()\\/.\\- ]");
            String number = String.join("", numberArgs);

            phonebook.put(name, number);
        }


        if (phonebook.size() > 0) {
            System.out.print("<ol>");
            for (String contact : phonebook.keySet()) {
                System.out.print(String.format("<li><b>%s:</b> %s</li>", contact, phonebook.get(contact)));
            }
            System.out.print("</ol>");
        } else {
            System.out.println("<p>No matches!</p>");
        }
    }
}
