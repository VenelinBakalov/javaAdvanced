import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHtml {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "<div((\\s+\\S+)*?)\\s*(id|class)\\s*=\\s*\"(.*?)\"((\\s+\\S+)*)\\s*>\\s*.*?\\s*<\\/div>\\s*<!--\\s*\\4\\s*-->";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder sb = new StringBuilder();

        String line;

        while (!"END".equals(line = reader.readLine())) {
            sb.append(line).append("\r\n");
        }
        Matcher matcher = pattern.matcher(sb);

        String result = getHtmlString(matcher, sb, pattern);
        System.out.println(result);
    }

    private static String getHtmlString(Matcher matcher, StringBuilder sb, Pattern pattern) {

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String beforeTag = "";
            String afterTag = "";

            if (matcher.group(1) != null) {
                beforeTag = matcher.group(1);

                Matcher beforeMatch = pattern.matcher(beforeTag);

                if (beforeMatch.find()) {
                    StringBuilder beforeSb = new StringBuilder(beforeTag);
                    beforeTag = getHtmlString(beforeMatch, beforeSb, pattern);
                }
            }
            if (matcher.group(5) != null) {
                afterTag = matcher.group(5);

                Matcher afterMatch = pattern.matcher(afterTag);

                if (afterMatch.find()) {
                    StringBuilder afterSb = new StringBuilder(beforeTag);
                    beforeTag = getHtmlString(afterMatch, afterSb, pattern);
                }
                result.append("<").append(matcher.group(4)).append(beforeTag).append(afterTag).append(">").append("\r\n</").append(matcher.group(4)).append(">");

                result.insert(0, sb.substring(0, matcher.start()));
                result.append(sb.substring(matcher.end()));

            }
        }
        return result.toString();
    }
}
