import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHtmlRetry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String openingRegex = "<div((\\s+\\S+)*?)\\s*(id|class)\\s*=\\s*\"(?<tag>\\w+)\"((\\s+\\S+)*?)\\s*>";
        String closingRegex = "<\\/div>\\s*<!--\\s*(?<tag>\\w+)\\s*-->";
        Pattern openingPattern = Pattern.compile(openingRegex);
        Pattern closingPattern = Pattern.compile(closingRegex);

        String line;

        while (!"END".equals(line = reader.readLine())) {
            Matcher openingMatch = openingPattern.matcher(line);
            Matcher closingMatch = closingPattern.matcher(line);
            StringBuilder currentTag = new StringBuilder();

            if (openingMatch.find()) {
                String beforeTag = openingMatch.group(1);
                String afterTag = openingMatch.group(5);
                currentTag.append("<").append(openingMatch.group("tag")).append(beforeTag).append(afterTag).append(">");

                String spaceRegex = "(\\s)+";
                Pattern spacePattern = Pattern.compile(spaceRegex);
                Matcher spaceMatch = spacePattern.matcher(currentTag);
                String result = currentTag.toString();

                if (spaceMatch.find()) {
                    result = spaceMatch.replaceAll("$1");
                }


                System.out.println(result);
            } else if (closingMatch.find()) {
                currentTag.append("</").append(closingMatch.group("tag")).append(">");
                System.out.println(currentTag);
            } else {
                System.out.println(line);
            }
        }

    }
}
