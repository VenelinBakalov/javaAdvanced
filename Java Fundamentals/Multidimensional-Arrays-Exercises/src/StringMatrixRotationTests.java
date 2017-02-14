import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotationTests {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rotation = reader.readLine().split("\\(|\\)");
        int angle = Integer.parseInt(rotation[1]);
        angle %= 360;

        List<char[]> matrix = new ArrayList<>();

        String input;
        int maxSize = Integer.MIN_VALUE;

        while (!"END".equals(input = reader.readLine())) {
            matrix.add(input.toCharArray());
            if (input.toCharArray().length > maxSize) {
                maxSize = input.toCharArray().length;
            }
        }

        int rotationTimes = angle / 90;

        switch (rotationTimes){

            case 0:
                for (int row = 0; row < matrix.size(); row++) {
                    for (int col = 0; col < maxSize; col++) {
                        if (col >= matrix.get(row).length) {
                            System.out.print(" ");
                        } else {
                            System.out.print(matrix.get(row)[col]);
                        }
                    }
                    System.out.println();
                }
                break;

            case 1:
            for (int col = 0; col < maxSize; col++) {
                for (int row = matrix.size() - 1; row >= 0; row--) {
                    if (col >= matrix.get(row).length) {
                        System.out.print(" ");
                    } else {
                        System.out.print(matrix.get(row)[col]);
                    }
                }
                System.out.println();
            }
            break;

            case 2:
                for (int row = matrix.size() - 1; row >= 0 ; row--) {
                    for (int col = maxSize - 1; col >= 0; col--) {
                        if (col >= matrix.get(row).length) {
                            System.out.print(" ");
                        } else {
                            System.out.print(matrix.get(row)[col]);
                        }
                    }
                    System.out.println();
                    
                }
                break;

            case 3:
                for (int col = maxSize - 1; col >= 0; col--) {
                    for (int row = 0; row < matrix.size(); row++) {
                        if (col >= matrix.get(row).length) {
                            System.out.print(" ");
                        } else
                            System.out.print(matrix.get(row)[col]);
                    }
                    System.out.println();
                }
                break;

        }
    }
}
