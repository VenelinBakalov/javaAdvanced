import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURLs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String[] protocolSplit = input.split("://");

        if (protocolSplit.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = protocolSplit[0];
        String urlRemainder = protocolSplit[1];

        int index = urlRemainder.indexOf("/");

        String server = urlRemainder.substring(0, index);
        String resources = urlRemainder.substring(index + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
