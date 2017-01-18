import java.util.Scanner;

public class MaxSequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int maxSequence = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length; row++) {
            int currentRow = 0;
            int currentCol = 0;
            int currentSequence = 1;
            int maxRow = 0;
            int maxCol = 0;
            while (currentRow < rows - 1 && currentCol < cols - 1 && matrix[currentRow][currentCol].equals(matrix[currentRow][currentCol + 1])) {
                currentSequence++;
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                    maxRow = currentRow;
                    maxCol = currentCol;
                }
                currentCol++;
            }

            currentRow = 0;
            currentCol = 0;
            currentSequence = 1;
            while (currentRow < rows - 1 && currentCol < cols - 1 && matrix[currentRow][currentCol].equals(matrix[currentRow + 1][currentCol])) {
                currentSequence++;
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                    maxRow = currentRow;
                    maxCol = currentCol;
                }
                currentRow++;
            }

            currentRow = 0;
            currentCol = 0;
            currentSequence = 1;
            while (currentRow < rows - 1 && currentCol < cols - 1 && matrix[currentRow][currentCol].equals(matrix[currentRow + 1][currentCol + 1])) {
                currentSequence++;
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                    maxRow = currentRow;
                    maxCol = currentCol;
                }
                currentRow++;
                currentCol++;
            }

            String maxString = matrix[maxRow][maxCol];
            for (int i = 0; i < maxSequence; i++) {
                System.out.print(maxString + ", ");
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] remainders = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = remainders[col];
            }
        }
    }
}
