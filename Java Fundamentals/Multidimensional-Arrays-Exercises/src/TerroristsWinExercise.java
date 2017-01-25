import java.util.Scanner;

public class TerroristsWinExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder inputText = new StringBuilder(scanner.nextLine());

        while (true) {
            int firstPipeIndex = inputText.indexOf("|");
            if (firstPipeIndex != -1) {
                int lastPipeIndex = inputText.indexOf("|", firstPipeIndex + 1);
                String bombContent = inputText.substring(firstPipeIndex + 1, lastPipeIndex);
                int bombPower = getBombPower(bombContent);
                int startIndex = Math.max(0, firstPipeIndex - bombPower);
                int endIndex = Math.min(inputText.length() - 1, lastPipeIndex + bombPower);

                while (startIndex <= endIndex) {
                    inputText.setCharAt(startIndex, '.');
                    startIndex++;
                }
            } else {
                break;
            }
        }

        System.out.println(inputText.toString());
    }

    private static int getBombPower(String bombContent) {
        int sum = 0;

        for (char symbol : bombContent.toCharArray()) {
            sum += symbol;
        }

        return sum % 10;
    }
}
