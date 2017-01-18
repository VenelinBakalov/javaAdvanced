import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        switch (pattern){
            case "A": fillMatrixPatternA(size, matrix); break;
            case "B": fillMatrixPatternB(size, matrix); break;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int size, int[][] matrix) {
        int numbers = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                if (col % 2 == 0) {
                    matrix[row][col] = numbers;
                } else {
                    matrix[size - row - 1][col] = numbers;
                }
                numbers++;
            }
        }
    }

    private static void fillMatrixPatternA(int size, int[][] matrix) {
        int numbers = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = numbers;
                numbers++;
            }
        }
    }
}
