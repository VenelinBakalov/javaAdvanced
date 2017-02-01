import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SpecialWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] specialWords = reader.readLine().split(" ");
        String[] text = reader.readLine().split(" ");

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String specialWord : specialWords) {

            wordsCount.put(specialWord, 0);

            for (String word : text) {

                if (specialWord.compareToIgnoreCase(word) == 0) {
                    wordsCount.put(specialWord, wordsCount.get(specialWord) + 1);
                }
            }
        }


        for (String word : wordsCount.keySet()) {
            System.out.println(String.format("%s - %d", word, wordsCount.get(word)));
        }
    }
}
