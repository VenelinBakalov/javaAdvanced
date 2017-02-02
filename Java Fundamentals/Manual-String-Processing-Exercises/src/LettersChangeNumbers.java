import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        StringBuilder alphabet = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            alphabet.append((char)i);
        }

    //    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        double resultTotal = 0;

        for (String word : input) {
            String firstLetter = word.substring(0, 1);
            String lastLetter = word.substring(word.length() - 1);
            double number = Double.valueOf(word.substring(1, word.length() - 1));

            int positionFirstLetter = alphabet.indexOf(firstLetter.toLowerCase()) + 1;
            int positionLastLetter = alphabet.indexOf(lastLetter.toLowerCase()) + 1;

            double currentResult = 0;

            if (firstLetter.equals(firstLetter.toUpperCase())) {
                currentResult = number / positionFirstLetter;
            } else if (firstLetter.equals(firstLetter.toLowerCase())){
                currentResult = number * positionFirstLetter;
            }

            if (lastLetter.equals(lastLetter.toUpperCase())) {
                currentResult -= positionLastLetter;
            } else if (lastLetter.equals(lastLetter.toLowerCase())) {
                currentResult += positionLastLetter;
            }

            resultTotal += currentResult;
        }

        System.out.println(String.format("%.2f", resultTotal));
    }
}
