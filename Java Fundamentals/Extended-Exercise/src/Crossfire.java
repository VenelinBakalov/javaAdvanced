import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        long token = 1;
        List<List<Long>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(token);
                token++;
            }
        }

        String command;
        while (!"Nuke it from orbit".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            long row = Long.parseLong(commandArgs[0]);
            long col = Long.parseLong(commandArgs[1]);
            long radius = Integer.parseInt(commandArgs[2]);
            long maxRow = row + radius > 200 ? 200 : row + radius;
            long minRow = row - radius < 0? 0 : row - radius;
            long maxCol = col + radius > 200 ? 200 : col + radius;
            long minCol = col - radius < 0 ? 0 : col - radius;

            for (long currentRow = maxRow; currentRow >= minRow; currentRow--) {
                if (currentRow == row) {
                    continue;
                }
                try {
                    matrix.get((int) currentRow).remove((int)col);
                } catch (IndexOutOfBoundsException e){}
            }

            for (long currentCol = maxCol; currentCol >= minCol; currentCol--) {
                try {
                    matrix.get((int) row).remove((int)currentCol);
                } catch (IndexOutOfBoundsException e){}
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
               sb.append(matrix.get(row).get(col) + " ");
            }
            sb.append("\r\n");
        }

        System.out.println(sb);
    }
}
