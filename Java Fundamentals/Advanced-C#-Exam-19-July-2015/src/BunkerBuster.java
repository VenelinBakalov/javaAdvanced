import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunkerBuster {

    private static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        Integer rows = Integer.parseInt(dimensions[0]);
        Integer cols = Integer.parseInt(dimensions[1]);
        matrix = new Integer[rows][cols];

        readMatrix(reader);

        String command;

        while (!"cease fire!".equals(command = reader.readLine())) {
            String[] tokens = command.split(" ");
            Integer impactRow = Integer.parseInt(tokens[0]);
            Integer impactCol = Integer.parseInt(tokens[1]);
            Integer damage = (int) tokens[2].charAt(0);

            commandExecute(impactRow, impactCol, damage);
        }

        int cellsDestroyed = findResult();
        Double percentage = cellsDestroyed * 100 / (double) (rows * cols);

        System.out.println("Destroyed bunkers: " + cellsDestroyed);
        System.out.println("Damage done: " + String.format("%.1f", percentage).replace(',', '.') + " %");
    }

    private static int findResult() {
        int counter = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] <= 0) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private static void commandExecute(Integer impactRow, Integer impactCol, Integer damage) {
        cellDamage(impactRow, impactCol, damage);

        damage = (int) Math.round(damage / 2.0);
        cellDamage(impactRow, impactCol + 1, damage);
        cellDamage(impactRow, impactCol - 1, damage);
        cellDamage(impactRow - 1, impactCol - 1, damage);
        cellDamage(impactRow - 1, impactCol, damage);
        cellDamage(impactRow - 1, impactCol + 1, damage);
        cellDamage(impactRow + 1, impactCol - 1, damage);
        cellDamage(impactRow + 1, impactCol, damage);
        cellDamage(impactRow + 1, impactCol + 1, damage);

    }

    private static void cellDamage(Integer impactRow, Integer impactCol, Integer damage) {
        if (impactRow < 0 || impactRow > matrix.length - 1
                || impactCol < 0 || impactCol > matrix[impactRow].length - 1) {
            return;
        }
        matrix[impactRow][impactCol] -= damage;

        // try {
        //     matrix[impactRow][impactCol] -= damage;
        // } catch (IndexOutOfBoundsException ex) {

        // }
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] remainders = reader.readLine().split(" ");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(remainders[col]);
            }
        }
    }
}
