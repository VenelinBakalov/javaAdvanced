import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split("\\s+");

        String firstString = inputLine[0];
        String secondString = inputLine[1];

        int result = characterMultiplicator(firstString, secondString);

        System.out.println(result);
    }

    private static int characterMultiplicator(String firstString, String secondString) {
        int index = Math.min(firstString.length(), secondString.length());

        int sum = 0;

        if (firstString.length() > secondString.length()) {
            for (int i = 0; i < firstString.length(); i++) {
                if (i < index){
                    sum += firstString.charAt(i) * secondString.charAt(i);
                }
                else {
                    sum += firstString.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < secondString.length(); i++) {
                if (i < index){
                    sum += firstString.charAt(i) * secondString.charAt(i);
                }
                else {
                    sum += secondString.charAt(i);
                }
            }
        }

        return sum;
    }
}
