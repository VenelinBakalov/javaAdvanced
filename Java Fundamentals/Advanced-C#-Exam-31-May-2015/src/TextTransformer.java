import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTransformer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;

        while (!"burp".equals(line = reader.readLine())) {
            sb.append(line);
        }

        String token = sb.toString().replaceAll("\\s+", " ");

        Pattern regex = Pattern.compile("(\\$|%|'|&)([^$%'&]+?)\\1");

        Matcher matcher = regex.matcher(token);

        sb = new StringBuilder();

        while (matcher.find()) {
            String match = matcher.group(2);
            switch (matcher.group(1)) {
                case "$":
                    sb.append(stringManipulate(1, match));
                    break;
                case "%":
                    sb.append(stringManipulate(2, match));
                    break;
                case "&":
                    sb.append(stringManipulate(3, match));
                    break;
                case "'":
                    sb.append(stringManipulate(4, match));
            }
        }

        System.out.println(sb);


    }

    private static String stringManipulate(int modifier, String group) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < group.length(); i++) {
            char c = group.charAt(i);
            if (i % 2 == 0) {
                c += modifier;
            } else {
                c -= modifier;
            }
            temp.append(c);
        }

        return temp.append(" ").toString();
    }

}
