import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class IndexOfLetters {
    public static void main(String[] args) throws IOException {

        char[] letters = new char[26];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = (char) ('a' + i);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();

        for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if (letters[j] == currentLetter) {
                    System.out.println(currentLetter + " -> " + j);
                    break;
                }
            }
        }

        /*
            for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            System.out.println(currentLetter + " -> " + ((int)currentLetter - 97));
        }
         */
    }
}
