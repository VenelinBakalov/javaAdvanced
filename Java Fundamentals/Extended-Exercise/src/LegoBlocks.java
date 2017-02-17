import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int matrixLength = Integer.parseInt(reader.readLine().trim());

        int[][] firstJaggedMatrix = new int[matrixLength][];
        int[][] secondJaggedMatrix = new int[matrixLength][];

        int blocksCount = 0;

        for (int row = 0; row < firstJaggedMatrix.length; row++) {
            String[] remainders = reader.readLine().trim().split("\\s+");
            firstJaggedMatrix[row] = new int[remainders.length];
            blocksCount += remainders.length;
            for (int col = 0; col < remainders.length; col++) {
                firstJaggedMatrix[row][col] = Integer.parseInt(remainders[col]);
            }
        }

        for (int row = 0; row < secondJaggedMatrix.length; row++) {
            String[] remainders = reader.readLine().trim().split("\\s+");
            secondJaggedMatrix[row] = new int[remainders.length];
            blocksCount += remainders.length;
            for (int col = 0; col < remainders.length; col++) {
                secondJaggedMatrix[row][col] = Integer.parseInt(remainders[col]);
            }
        }

        int matrixTotalWidth = firstJaggedMatrix[0].length + secondJaggedMatrix[0].length;

        for (int i = 0; i < matrixLength; i++) {
            if (firstJaggedMatrix[i].length + secondJaggedMatrix[i].length != matrixTotalWidth) {
                System.out.println("The total number of cells is: " + blocksCount);
                return;
            }
        }

        List<List<String>> lego = new ArrayList<>();

        for (int row = 0; row < matrixLength; row++) {
            lego.add(new ArrayList<>());
            for (int col = 0; col < matrixTotalWidth; col++) {
                if (col < firstJaggedMatrix[row].length) {
                    lego.get(row).add(String.valueOf(firstJaggedMatrix[row][col]));
                } else {
                    lego.get(row).add(String.valueOf(secondJaggedMatrix[row][matrixTotalWidth - 1 - col]));
                }
            }
        }

        for (List<String> blocks : lego) {
            System.out.println("[" + String.join(", ", blocks) + "]");
        }
    }
}
