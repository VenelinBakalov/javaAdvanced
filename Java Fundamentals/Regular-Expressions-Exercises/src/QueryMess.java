import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<field>[^?&]+?)=(?<value>[^?]+?(?=&|$))";
        Pattern pattern = Pattern.compile(regex);

        String line = reader.readLine();

        while (!"END".equals(line)) {
            Map<String, List<String>> fieldAndValues = new LinkedHashMap<>();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {

                String field = String.join(" ",matcher.group("field").split("%20|\\+")).trim();
                String[] values = matcher.group("value").split("%20|\\+");

                List<String> valuesList = new ArrayList<>();

                for (String value : values) {
                    if (!"".equals(value)) {
                        valuesList.add(value);
                    }
                }

                String value = String.join(" ", valuesList).trim();

                if (!fieldAndValues.containsKey(field)) {
                    fieldAndValues.put(field, new ArrayList<>());
                }

                fieldAndValues.get(field).add(value);
            }

            for (Map.Entry<String, List<String>> pair : fieldAndValues.entrySet()) {
                System.out.print(String.format("%s=[%s]", pair.getKey(), String.join(", ",pair.getValue())));
            }
            System.out.println();

            line = reader.readLine();
        }


    }
}
