import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 3.7.2017 г..
 */
public class ChangeToUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int openingTagIndex = text.indexOf("<upcase>");

        while (openingTagIndex != -1) {
            int closingTagIndex = text.indexOf("</upcase>");
            String textToBeChanged = text.substring(openingTagIndex + 8, closingTagIndex);
            text = text.replace("<upcase>" + textToBeChanged + "</upcase>", textToBeChanged.toUpperCase());
            openingTagIndex = text.indexOf("<upcase>");
        }

        System.out.println(text);
    }
}
