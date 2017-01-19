import java.util.ArrayList;
import java.util.Scanner;

public class GameOfNamesWithClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        ArrayList<Player> players = new ArrayList<>();

        int maxScore = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < count; i++) {
            char[] nameAsChars = scanner.nextLine().toCharArray();
            int score = Integer.parseInt(scanner.nextLine());

            for (char character : nameAsChars) {
                if (character % 2 == 0) {
                    score += character;
                } else {
                    score -= character;
                }
            }

            String name = new String(nameAsChars);

            Player player = new Player(name, score);
            players.add(player);
        }

        players.sort((a, b) -> ((Integer)b.score).compareTo(((Integer)a.score)));

        System.out.printf("The winner is %s - %d points", players.get(0).name, players.get(0).score);
    }

    public static class Player{
        String name;
        int score;

        public Player(String name, int score ) {
            this.name = name;
            this.score = score;
        }
    }
}
