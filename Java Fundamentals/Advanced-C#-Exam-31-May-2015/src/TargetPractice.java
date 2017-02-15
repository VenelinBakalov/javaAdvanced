import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TargetPractice {
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = reader.readLine().split(" ");
        String snake = reader.readLine();

        matrix = new String[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        StringBuilder sb = new StringBuilder(snake);

        fillMatrix(sb);

        String[] command = reader.readLine().split(" ");

        shotMatrix(command);
        gravity();

        printMatrix();
    }

    private static void gravity() {

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 2; j >= 0; j--) {
                if (!matrix[j][i].equals(" ")) {
                    for (int k = j; k < matrix.length - 1; k++) {
                        if (matrix[k + 1][i].equals(" ")) {
                            matrix[k + 1][i] = matrix[k][i];
                            matrix[k][i] = " ";
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void shotMatrix(String[] command) {
        int impactRow = Integer.parseInt(command[0]);
        int impactCol = Integer.parseInt(command[1]);
        int radius = Integer.parseInt(command[2]);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (Math.pow(row - impactRow, 2) + Math.pow(col - impactCol, 2) <= radius * radius) {
                    matrix[row][col] = " ";
                }
            }
        }

    }

    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(StringBuilder sb) {
        boolean isMovingLeft = true;

        for (int row = matrix.length - 1; row >= 0; row--) {

            if (isMovingLeft) {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    matrix[row][col] = String.valueOf(sb.charAt(0));
                    sb.append(sb.charAt(0));
                    sb.deleteCharAt(0);
                }
                isMovingLeft = false;
            } else {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = String.valueOf(sb.charAt(0));
                    sb.append(sb.charAt(0));
                    sb.deleteCharAt(0);
                }
                isMovingLeft = true;
            }

        }
    }
}
