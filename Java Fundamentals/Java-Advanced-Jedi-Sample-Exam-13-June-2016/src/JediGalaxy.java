import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] galaxy = new int[dimensions[0]][dimensions[1]];

        int tempValue = 0;

        for (int row = 0; row < galaxy.length; row++) {
            for (int col = 0; col < galaxy[row].length; col++) {
                galaxy[row][col] = tempValue;
                tempValue++;
            }
        }

        String input;

        Long ivosForce = 0L;

        while (!"Let the Force be with you".equals(input = reader.readLine())) {
            String[] ivoString = input.split(" ");
            String[] evilString = reader.readLine().split(" ");

            int ivoRow = Integer.parseInt(ivoString[0]);
            int ivoCol = Integer.parseInt(ivoString[1]);

            int evilRow = Integer.parseInt(evilString[0]);
            int evilCol = Integer.parseInt(evilString[1]);

            if (evilCol >= 0) {
                for (int i = 0; i <= evilRow ; i++) {
                    if (evilCol - i > dimensions[1] - 1 || evilRow - i > dimensions[0] - 1) {
                        continue;
                    }
                    if (evilCol - i < 0) {
                        break;
                    }
                    galaxy[evilRow - i][evilCol - i] = 0;
                }
            }

            for (int i = 0; i <= ivoRow; i++) {
                if (ivoCol + i < 0 || ivoRow - i >= dimensions[0]) {
                    continue;
                }
                if (ivoCol + i >= dimensions[1]) {
                    break;
                }
                ivosForce += galaxy[ivoRow - i][ivoCol + i];
            }

        }

        System.out.println(ivosForce);
    }
}
