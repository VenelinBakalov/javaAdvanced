import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, alphabet);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, char[] alphabet) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.format("%s%s%s", alphabet[row], alphabet[col + row], alphabet[row]);
            }
        }
    }
}
