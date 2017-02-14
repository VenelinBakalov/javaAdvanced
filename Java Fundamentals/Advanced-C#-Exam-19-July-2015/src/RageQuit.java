import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RageQuit {
    private static Set<Character> chars = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([^\\d]{1,20})([\\d]{0,20})";
        Pattern pattern = Pattern.compile(regex);

        String input = reader.readLine();

        Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String str = matcher.group(1).toUpperCase();
            int count = Integer.parseInt(matcher.group(2));

            if (count != 0) {
                for (int i = 0; i < str.length(); i++) {
                    chars.add(str.charAt(i));
                }
            }
            for (int i = 0; i < count; i++) {
                sb.append(str);
            }
        }

        System.out.println("Unique symbols used: " + chars.size());
        System.out.println(sb);
    }
}
