import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        String shockwave;

        while (!"Here We Go".equals(shockwave = reader.readLine())) {
            String[] shockArgs = shockwave.split(" ");
            int upleftRow = Integer.parseInt(shockArgs[0]);
            int upleftCol = Integer.parseInt(shockArgs[1]);
            int botrightRow = Integer.parseInt(shockArgs[2]);
            int botrightCol = Integer.parseInt(shockArgs[3]);

            for (int row = upleftRow; row <= botrightRow; row++) {
                for (int col = upleftCol; col <= botrightCol; col++) {
                    matrix[row][col]++;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
