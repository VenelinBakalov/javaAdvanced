import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicsMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^(\\d+)([a-zA-Z]+)([^a-zA-Z]*?)$";
        Pattern pattern = Pattern.compile(regex);

        String input;

        while (!"Over!".equals(input = reader.readLine())) {

            int verificationNumber = Integer.parseInt(reader.readLine());
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String message = matcher.group(2);

                if (message.length() != verificationNumber) {
                    continue;
                }

                StringBuilder sb = new StringBuilder(message);
                sb.append(" == ");

                String leftGroup = matcher.group(1);
                String rightGroup = matcher.group(3);

                for (char c : leftGroup.toCharArray()) {
                    int index = Integer.parseInt(String.valueOf(c));

                    if (index < message.length()) {
                        sb.append(message.charAt(index));
                    } else {
                        sb.append(" ");
                    }
                }

                for (char c : rightGroup.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        continue;
                    }

                    int index = Integer.parseInt(String.valueOf(c));

                    if (index < message.length()) {
                        sb.append(message.charAt(index));
                    } else {
                        sb.append(" ");
                    }
                }

                System.out.println(sb);
            }
        }
    }
}
