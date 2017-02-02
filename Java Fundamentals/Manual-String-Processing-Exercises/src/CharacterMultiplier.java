import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");

        String firstString = strings[0];
        String secondString = strings[1];

        int lowerIndex = Math.min(firstString.length(), secondString.length());

        int sum = 0;

        if (firstString.length() > secondString.length()) {

            for (int i = 0; i < firstString.length(); i++) {

                if (i < lowerIndex) {
                    sum += (firstString.charAt(i) * secondString.charAt(i));
                } else {
                    sum += firstString.charAt(i);
                }
            }
        } else {

            for (int i = 0; i < secondString.length(); i++) {

                if (i < lowerIndex) {
                    sum += (firstString.charAt(i) * secondString.charAt(i));
                } else {
                    sum += secondString.charAt(i);
                }
            }
        }


        System.out.println(sum);
    }
}
