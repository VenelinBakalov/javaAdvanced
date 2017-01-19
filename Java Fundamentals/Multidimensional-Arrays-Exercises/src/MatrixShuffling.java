import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] remainders = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(remainders[col]);
            }
        }

        String[] commandLine = scanner.nextLine().split(" ");

        while (!commandLine[0].equals("END")) {

            if (commandLine[0].equals("swap") && commandLine.length == 5) {
                int firstNumberRow = Integer.parseInt(commandLine[1]);
                int firstNumberCol = Integer.parseInt(commandLine[2]);

                int secondNumberRow = Integer.parseInt(commandLine[3]);
                int secondNumberCol = Integer.parseInt(commandLine[4]);

                if (firstNumberRow >= rows || secondNumberRow >= rows
                        || firstNumberCol >= cols || secondNumberCol >= cols) {
                    System.out.println("Invalid input!");
                } else {

                    int temp = matrix[firstNumberRow][firstNumberCol];
                    matrix[firstNumberRow][firstNumberCol] = matrix[secondNumberRow][secondNumberCol];
                    matrix[secondNumberRow][secondNumberCol] = temp;

                    printMatrix(matrix);
                }
            } else {
                System.out.println("Invalid input!");
            }

            commandLine = scanner.nextLine().split(" ");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
