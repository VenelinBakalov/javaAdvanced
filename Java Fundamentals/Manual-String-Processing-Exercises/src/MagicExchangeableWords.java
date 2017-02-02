import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");
        char[] firstWord = words[0].toCharArray();
        char[] secondWord = words[1].toCharArray();

        Map<Character, Character> magicWords = new HashMap<>();

        if (firstWord.length > secondWord.length) {

            for (int i = 0; i < secondWord.length; i++) {

                if (!magicWords.containsKey(firstWord[i])) {
                    if (!magicWords.containsValue(secondWord[i])) {
                        magicWords.put(firstWord[i], secondWord[i]);
                    } else {
                        System.out.println(false);
                        return;
                    }
                } else if (magicWords.get(firstWord[i]) != secondWord[i]) {
                    System.out.println(false);
                    return;
                }
            }

            for (int i = secondWord.length; i < firstWord.length; i++) {
                if (!magicWords.containsKey(firstWord[i])) {
                    System.out.println(false);
                    return;
                }
            }
        } else {
            for (int i = 0; i < firstWord.length; i++) {

                if (!magicWords.containsKey(firstWord[i])) {
                    if (!magicWords.containsValue(secondWord[i])) {
                        magicWords.put(firstWord[i], secondWord[i]);
                    } else {
                        System.out.println(false);
                        return;
                    }
                } else if (magicWords.get(firstWord[i]) != secondWord[i]) {
                    System.out.println(false);
                    return;
                }
            }

            for (int i = firstWord.length; i < secondWord.length; i++) {
                if (!magicWords.containsValue(secondWord[i])) {
                    System.out.println(false);
                    return;
                }

            }
        }
        System.out.println(true);
    }
}