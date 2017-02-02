import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());

        while (true) {

            if (pattern.length() == 0) {
                System.out.println("No shake.");
                System.out.println(text);
                return;
            }

            int firstIndex = text.indexOf(pattern.toString());
            int lastIndex = text.lastIndexOf(pattern.toString());

            if (firstIndex == -1 || lastIndex == -1 || firstIndex == lastIndex) {
                System.out.println("No shake.");
                System.out.println(text);
                return;
            }

            text.delete(lastIndex, lastIndex + pattern.length());
            text.delete(firstIndex, firstIndex + pattern.length());

            System.out.println("Shaked it.");

            pattern.deleteCharAt(pattern.length() / 2);
        }
    }
}
