import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regexNiceIsntIt = "(^| )(?<holyMail>[a-zA-Z0-9]+([-_.]*[a-zA-Z0-9]+)*@[a-zA-Z]+(-[a-zA-Z]+)*(\\.[a-zA-Z]+(-[a-zA-Z]+)*)+)(\\.|,| |$)";
        Pattern pattern = Pattern.compile(regexNiceIsntIt);
        String havingFunWithRegexAndMails = reader.readLine();

        Matcher matcher = pattern.matcher(havingFunWithRegexAndMails);

        while (matcher.find()) {
            System.out.println(matcher.group("holyMail"));
        }
    }
}
