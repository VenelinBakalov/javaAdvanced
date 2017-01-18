import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] remainder = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(remainder[col]);
            }
        }

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            primaryDiagonal += matrix[row][row];
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            secondaryDiagonal += matrix[row][matrix.length - 1 - row];
        }

        int difference = Math.abs(primaryDiagonal - secondaryDiagonal);

        System.out.println(difference);
    }
}
