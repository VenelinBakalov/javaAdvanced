import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHtml {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "<div((\\s+\\S+)*?)\\s*(id|class)\\s*=\\s*\"(.*?)\"((\\s+\\S+)*)\\s*>.*?\\s*<\\/div>\\s*<!--\\s*\\4\\s*-->";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder sb = new StringBuilder();

        String line;

        while (!"END".equals(line = reader.readLine())) {
            sb.append(line).append("\r\n");
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            StringBuilder result = new StringBuilder();
            String beforeTag = "";
            String afterTag = "";

            if (matcher.group(1) != null) {
                beforeTag = matcher.group(1);
            }
            if (matcher.group(5) != null) {
                afterTag = matcher.group(5);
            }
            result.append("<").append(matcher.group(4)).append(beforeTag).append(afterTag).append(">").append("\r\n</").append(matcher.group(4)).append(">");

            result.insert(0, sb.substring(0, matcher.start()));
            result.append(sb.substring(matcher.end()));
            System.out.println(result);
        }
    }
}
