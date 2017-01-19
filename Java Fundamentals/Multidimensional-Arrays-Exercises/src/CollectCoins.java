import java.util.Scanner;

public class CollectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[4][];

        for (int row = 0; row < matrix.length; row++) {
            char[] remainders = scanner.nextLine().toCharArray();
            matrix[row] = new char[remainders.length];
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = remainders[col];
            }
        }

        char[] commands = scanner.nextLine().toCharArray();

        int coins = 0;
        int wallsHit = 0;

        int currentLocationRow = 0;
        int currentLocationCol = 0;

        for (char command : commands) {
            switch (command) {
                case '>':
                    currentLocationCol++;
                    if (currentLocationCol >= matrix[currentLocationRow].length) {
                        currentLocationCol--;
                        wallsHit++;
                    } else if (matrix[currentLocationRow][currentLocationCol] == '$'){
                        coins++;
                    }
                    break;
                case '<':
                    currentLocationCol--;
                    if (currentLocationCol < 0) {
                        currentLocationCol++;
                        wallsHit++;
                    } else if (matrix[currentLocationRow][currentLocationCol] == '$'){
                        coins++;
                    }
                    break;
                case '^':
                    currentLocationRow--;
                    if (currentLocationRow < 0) {
                        currentLocationRow++;
                        wallsHit++;
                    } else if (matrix[currentLocationRow][currentLocationCol] == '$'){
                        coins++;
                    }
                    break;
                case 'V':
                    currentLocationRow++;
                    if (currentLocationRow > matrix.length - 1
                            || currentLocationCol >= matrix[currentLocationRow].length) {
                        currentLocationRow--;
                        wallsHit++;
                    } else if (matrix[currentLocationRow][currentLocationCol] == '$'){
                        coins++;
                    }
                    break;
            }
        }

        System.out.printf("Coins = %d%n", coins);
        System.out.printf("Walls = %d", wallsHit);
    }
}
