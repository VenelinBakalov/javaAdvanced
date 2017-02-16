import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractHyperlinksString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            text.append(line);
        }

        int index = 0;
        index = text.indexOf("<a");

        while (index != -1) {

            index = text.indexOf("<a", index + 1);
        }
    }
}
