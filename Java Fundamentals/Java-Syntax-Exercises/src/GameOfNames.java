import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int maxScore = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < count; i++) {
            char[] name = scanner.nextLine().toCharArray();
            int score = Integer.parseInt(scanner.nextLine());

            for (char character : name) {
                if (character % 2 == 0) {
                    score += character;
                } else {
                    score -= character;
                }
            }

            if (score > maxScore) {
                maxScore = score;
                winner = new String(name);
            }
        }

        System.out.printf("The winner is %s - %d points", winner, maxScore);
    }
}
