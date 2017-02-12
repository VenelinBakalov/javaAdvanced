import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubicsRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dimension = Integer.parseInt(reader.readLine());

        Long[][][] cube = new Long[dimension][dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                for (int height = 0; height < dimension; height++) {
                    cube[row][col][height] = 0L;
                }
            }
        }

        String[] input = reader.readLine().split(" ");

        while (!"Analyze".equals(input[0])) {
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            int height = Integer.parseInt(input[2]);

            if (row >= 0  && row < dimension
                    && col >= 0 && col < dimension
                    && height >= 0 && height < dimension) {

                Long value = Long.valueOf(input[3]);

                cube[row][col][height] = value;
            }
            input = reader.readLine().split(" ");
        }

        Long sum = 0L;
        Long unchangedValues = 0L;

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                for (int height = 0; height < dimension; height++) {

                    if (cube[row][col][height] == 0) {
                        unchangedValues++;
                    } else {
                        sum += cube[row][col][height];
                    }
                }
            }
        }

        System.out.println(sum);
        System.out.println(unchangedValues);
    }
}
