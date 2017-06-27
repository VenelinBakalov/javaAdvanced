import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class VowelOrDigit {
    public static void main(String[] args) throws IOException {
        List<Character> vowels = Arrays.asList('a', 'e', 'o', 'u', 'i');

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char symbol = reader.readLine().charAt(0);

        if (vowels.contains(symbol)) {
            System.out.println("vowel");
        } else if (Character.isDigit(symbol)) {
            System.out.println("digit");
        } else {
            System.out.println("other");
        }
    }
}
