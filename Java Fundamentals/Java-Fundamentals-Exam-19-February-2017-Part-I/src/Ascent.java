import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<delimiter>[,_])(?<message>[a-zA-Z]+)(?<digit>[0-9])";
        Pattern pattern = Pattern.compile(regex);
        String input;
        Map<String, String> messages = new LinkedHashMap<>();

        while (!"Ascend".equals(input = reader.readLine().trim())) {

            for (String message : messages.keySet()) {
                input = input.replaceAll(message, messages.get(message));
            }
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {

                String delimiter = matcher.group("delimiter");
                String message = matcher.group("message");
                Integer digit = Integer.parseInt(matcher.group("digit"));
                StringBuilder resultingMessage = new StringBuilder();

                switch (delimiter){
                    case ",":
                        for (char character : message.toCharArray()) {
                            character += digit;
                            resultingMessage.append(character);
                        }
                        break;
                    case "_":
                        for (char character : message.toCharArray()) {
                            character -= digit;
                            resultingMessage.append(character);
                        }
                        break;
                }

                input = input.replaceAll(matcher.group(), String.valueOf(resultingMessage));
                messages.put(matcher.group(), resultingMessage.toString());
            }
            System.out.println(input);
        }
    }
}
