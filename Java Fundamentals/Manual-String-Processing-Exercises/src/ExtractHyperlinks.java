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
        String regex = "<a.*?href\\s*?=\\s*?(\"|')(?<answer>.+?)\\1.*?>";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder sb = new StringBuilder();

        String htmlFragment;

        while (!"END".equals(htmlFragment = reader.readLine())) {
            sb.append(htmlFragment);
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            System.out.println(matcher.group("answer"));
        }
    }
}
