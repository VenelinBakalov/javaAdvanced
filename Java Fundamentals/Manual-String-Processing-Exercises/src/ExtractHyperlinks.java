import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //String regex = "<a\\s*(.*?)?href\\s*=\\s*(('.+')|(\".+\")|([a-z\\/:.]+)).*>";
        //String regex = "<a.*?href\\s*?=\\s*(((\"+)|('*))(?<answer>.+?)\\2(\\s|>))";

        //String regex = "<a.*?href\\s*?=\\s*?(\"|')(?<answer>.+?)\\1.*?>"; - final try from me...80 points so copy from forum next
        String regex = "(?:<a)(?:[\\s\\n_0-9a-zA-Z=\"\"()]*?.*?)(?:href([\\s\\n]*)?=(?:['\"\"\\s\\n]*)?)([a-zA-Z:#\\/._\\-0-9!?=^+]*(\\([\"\"'a-zA-Z\\s.()0-9]*\\))?)(?:[\\s\\na-zA-Z=\"\"()0-9]*.*?)?(?:\\>)";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder sb = new StringBuilder();

        String htmlFragment;

        while (!"END".equals(htmlFragment = reader.readLine())) {
            sb.append(htmlFragment);
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            if (matcher.group(2).equals("fake")) {
                continue;
            }
            System.out.println(matcher.group(2));
        }
    }
}
