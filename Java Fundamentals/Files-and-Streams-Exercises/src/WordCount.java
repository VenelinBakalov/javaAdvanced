import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String WORDS_FILE_PATH = PROJECT_PATH + "words.txt";
    private static final String TEXT_FILE_PATH = PROJECT_PATH + "text.txt";
    private static final String RESULT_FILE_PATH = PROJECT_PATH + "results.txt";

    public static void main(String[] args) {

        Map<String, Integer> wordsCount = new HashMap<>();
        Map<String, String> wordsOriginal = new HashMap<>();


        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_FILE_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE_PATH))) {

            String line;
            while ((line = wordsReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if (!wordsCount.containsKey(wordKey)) {
                        wordsCount.put(wordKey, 0);
                        wordsOriginal.put(wordKey, word);
                    }
                }
            }

            while ((line = textReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if (wordsCount.containsKey(wordKey)) {
                        String key = wordKey;
                        Integer count = wordsCount.get(key) + 1;
                        wordsCount.put(key, count);
                    }
                }
            }

            wordsCount.entrySet().stream().sorted((e1, e2) -> e2.getValue()
                    .compareTo(e1.getValue()))
                    .forEach(pair -> {
                        try {
                            writer.write(String.format("%s - %d", wordsOriginal.get(pair.getKey())
                                    , pair.getValue()) + System.lineSeparator());
                            //writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
