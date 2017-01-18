import java.util.Scanner;

public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, scanner);

        int equalSquaresCount = getEqualSquaresCount(matrix);

        System.out.println(equalSquaresCount);
    }

    private static int getEqualSquaresCount(char[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (matrix[row][col] == matrix[row][col + 1]
                        && matrix[row][col] == matrix[row + 1][col]
                        && matrix[row][col] == matrix[row + 1][col + 1]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] remainders = scanner.nextLine().split(" ");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = remainders[col].charAt(0);
            }
        }
    }


}
