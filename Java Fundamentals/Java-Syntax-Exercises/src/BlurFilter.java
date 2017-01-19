import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurFilter = Integer.parseInt(scanner.nextLine());
        String[] matrixSize = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        long[][] matrix = new long[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] remainders = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Long.parseLong(remainders[col]);
            }
        }

        String[] coordinates = scanner.nextLine().split(" ");
        int targetRow = Integer.parseInt(coordinates[0]);
        int targetCol = Integer.parseInt(coordinates[1]);

        int left = Math.max(targetCol - 1, 0);
        int right = Math.min(targetCol + 1, cols - 1);
        int top = Math.max(targetRow - 1, 0);
        int bottom = Math.min(targetRow + 1, rows - 1);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((left <= col && col <= right) && (top <= row && row <= bottom)) {
                    System.out.printf("%d ", matrix[row][col] + blurFilter);
                } else {
                    System.out.printf("%d ", matrix[row][col]);
                }
            }
            System.out.println();
        }




    }
}
