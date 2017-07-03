import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 3.7.2017 г..
 */
public class URLParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String protocol = "";
        String resource = "";

        int protocolEndIndex = url.indexOf("://");
        if (protocolEndIndex != -1) {
            protocol = url.substring(0, protocolEndIndex);
            url = url.substring(protocolEndIndex + 3);
        }

        int resourcesIndex = url.indexOf("/");
        if (resourcesIndex != -1) {
            resource = url.substring(resourcesIndex + 1);
            url = url.substring(0, resourcesIndex);
        }
        System.out.printf("[protocol] = \"%s\"%n", protocol);
        System.out.printf("[server] = \"%s\"%n", url);
        System.out.printf("[resource] = \"%s\"%n", resource);

    }
}
