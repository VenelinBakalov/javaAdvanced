import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class RubiksMatrix {
    private static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        matrix = new int[dimensions[0]][dimensions[1]];
        int counter = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

        int commandsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] commandArgs = reader.readLine().split(" ");
            String direction = commandArgs[1];
            int rowCol = Integer.parseInt(commandArgs[0]);
            int moves = Integer.parseInt(commandArgs[2]);

            if (direction.equals("left") || direction.equals("right")) {
                moves %= matrix[0].length;
            } else {
                moves %= matrix.length;
            }

            for (int j = 0; j < moves; j++) {
                int tempVal;
                switch (direction) {
                    case "up":
                        tempVal = matrix[0][rowCol];
                        for (int row = 0; row <= matrix.length - 2; row++) {
                            matrix[row][rowCol] = matrix[row + 1][rowCol];
                        }
                        matrix[matrix.length - 1][rowCol] = tempVal;
                        break;
                    case "down":
                        tempVal = matrix[matrix.length - 1][rowCol];
                        for (int row = matrix.length - 1; row >= 1; row--) {
                            matrix[row][rowCol] = matrix[row - 1][rowCol];
                        }
                        matrix[0][rowCol] = tempVal;
                        break;
                    case "left":
                        tempVal = matrix[rowCol][0];
                        for (int col = 0; col < matrix[rowCol].length - 1; col++) {
                            matrix[rowCol][col] = matrix[rowCol][col + 1];
                        }
                        matrix[rowCol][matrix[rowCol].length - 1] = tempVal;
                        break;
                    case "right":
                        tempVal = matrix[rowCol][matrix[rowCol].length - 1];
                        for (int col = matrix[rowCol].length - 1; col >= 1; col--) {
                            matrix[rowCol][col] = matrix[rowCol][col - 1];
                        }
                        matrix[rowCol][0] = tempVal;
                        break;
                }
            }
        }

        counter = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] != counter) {
                    boolean isFound = false;
                    for (int findRow = 0; findRow < matrix.length; findRow++) {
                        for (int findCol = 0; findCol < matrix[findRow].length; findCol++) {

                            if (matrix[findRow][findCol] == counter) {
                                matrix[findRow][findCol] = matrix[row][col];
                                matrix[row][col] = counter;
                                System.out.println(String.format("Swap (%s, %s) with (%s, %s)", row, col, findRow, findCol));
                                isFound = true;
                                break;
                            }
                        }
                        if (isFound) {
                            break;
                        }
                    }
                } else {
                    System.out.println("No swap required");
                }
                counter++;
            }
        }
    }
}
