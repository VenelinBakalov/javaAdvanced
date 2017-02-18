import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RadioactiveBunnies {
    private static char[][] lair;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        lair = new char[rows][cols];

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < lair.length; row++) {
            char[] remainders = reader.readLine().toCharArray();
            for (int col = 0; col < lair[row].length; col++) {
                lair[row][col] = remainders[col];

                if (lair[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                    lair[row][col] = '.';
                }
            }
        }

        char[] commands = reader.readLine().toCharArray();

        String deadOrWon = "alive";

        for (char command : commands) {
            int nextCol;
            int nextRow;
            switch (command) {
                case 'L':
                    nextCol = playerCol - 1;
                    if (nextCol < 0) {
                        deadOrWon = "won";
                        break;
                    }
                    playerCol = nextCol;
                    break;
                case 'R':
                    nextCol = playerCol + 1;
                    if (nextCol > cols - 1) {
                        deadOrWon = "won";
                        break;
                    }
                    playerCol = nextCol;
                    break;
                case 'U':
                    nextRow = playerRow - 1;
                    if (nextRow < 0) {
                        deadOrWon = "won";
                        break;
                    }
                    playerRow = nextRow;
                    break;
                case 'D':
                    nextRow = playerRow + 1;
                    if (nextRow > rows - 1) {
                        deadOrWon = "won";
                        break;
                    }
                    playerRow = nextRow;
            }

            if (lair[playerRow][playerCol] == 'B') {
                deadOrWon = "dead";
            }

            for (int row = 0; row < lair.length; row++) {
                for (int col = 0; col < lair[row].length; col++) {
                    if (lair[row][col] == 'B') {
                        if (row - 1 >= 0 && lair[row - 1][col] == '.') {
                            lair[row - 1][col] = 'N';
                        }
                        if (row + 1 < rows && lair[row + 1][col] == '.') {
                            lair[row + 1][col] = 'N';
                        }
                        if (col - 1 >= 0 &&  lair[row][col - 1] == '.') {
                            lair[row][col - 1] = 'N';
                        }
                        if (col + 1 < cols && lair[row][col + 1] == '.') {
                            lair[row][col + 1] = 'N';
                        }
                    }
                }
            }

            for (int row = 0; row < lair.length; row++) {
                for (int col = 0; col < lair[row].length; col++) {
                    if (lair[row][col] == 'N') {
                        lair[row][col] = 'B';
                        if (row == playerRow && col == playerCol && deadOrWon.equals("alive")) {
                            deadOrWon = "dead";
                        }

                    }

                }
            }

            if (!deadOrWon.equals("alive")) {
                break;
            }
        }

        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                System.out.print(lair[row][col]);
            }
            System.out.println();
        }

        switch (deadOrWon) {
            case "dead":
                System.out.println(String.format("dead: %s %s", playerRow, playerCol));
                break;
            case "won":
                System.out.println(String.format("won: %s %s", playerRow, playerCol));
                break;
        }

    }
}
