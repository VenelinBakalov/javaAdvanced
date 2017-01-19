import java.util.Scanner;

public class TerroristsWinTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] result = input.toCharArray();

        int tempIndex = 0;

        while (input.indexOf('|', tempIndex) != -1) {

            int startIndex = input.indexOf('|', tempIndex);
            int endIndex = input.indexOf('|', startIndex + 1);
            char[] bombArray = input.substring(startIndex + 1, endIndex).toCharArray();

            int sum = 0;

            for (char c : bombArray) {
                sum += c;
            }

            int bombPower = sum % 10;

            int destroyedCharsLeftEdge = Math.max(0, startIndex - bombPower);
            int destroyedCharsRightEdge = Math.min(input.length() - 1, endIndex + bombPower);

            for (int i = destroyedCharsLeftEdge; i <= destroyedCharsRightEdge; i++) {
                result[i] = '.';
            }

            tempIndex = endIndex + 1;
        }

        System.out.println(result);
    }
}
