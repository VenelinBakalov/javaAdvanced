import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Venelin on 27.4.2017 г..
 */
public class Main {

    static String[][] matrix = new String[][]{
            {"0", "0", "0", "x", "0", "x"},
            {"0", "x", "0", "x", "0", "x"},
            {"0", "*", "x", "0", "x", "0"},
            {"0", "x", "0", "0", "0", "0"},
            {"0", "0", "0", "x", "x", "0"},
            {"0", "0", "0", "x", "0", "x"},
    };

    public static void main(String[] args) {
        int row = 2;
        int col = 1;

        Deque<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(row, col, 0));

        while (queue.size() > 0) {
            Cell currentCell = queue.pop();
            if (currentCell.getRow() > 0 &&
                    matrix[currentCell.getRow() - 1][currentCell.getCol()].equals("0")) {
                Cell newCell = new Cell(currentCell.getRow() - 1, currentCell.getCol(), currentCell.getStep() + 1);
                queue.add(newCell);
                matrix[newCell.getRow()][newCell.getCol()] = newCell.getStep() + "";
            }

            if (currentCell.getCol() < matrix[currentCell.getRow()].length - 1 &&
                    matrix[currentCell.getRow()][currentCell.getCol() + 1].equals("0")) {
                Cell newCell = new Cell(currentCell.getRow(), currentCell.getCol() + 1, currentCell.getStep() + 1);
                queue.add(newCell);
                matrix[newCell.getRow()][newCell.getCol()] = newCell.getStep() + "";
            }

            if (currentCell.getRow() < matrix.length - 1 &&
                    matrix[currentCell.getRow() + 1][currentCell.getCol()].equals("0")) {
                Cell newCell = new Cell(currentCell.getRow() + 1, currentCell.getCol(), currentCell.getStep() + 1);
                queue.add(newCell);
                matrix[newCell.getRow()][newCell.getCol()] = newCell.getStep() + "";
            }

            if (currentCell.getCol() > 0 &&
                    matrix[currentCell.getRow()][currentCell.getCol() - 1].equals("0")) {
                Cell newCell = new Cell(currentCell.getRow(), currentCell.getCol() - 1, currentCell.getStep() + 1);
                queue.add(newCell);
                matrix[newCell.getRow()][newCell.getCol()] = newCell.getStep() + "";
            }
        }

        for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
            for (int currentCol = 0; currentCol < matrix[currentRow].length; currentCol++) {

                System.out.printf("%s ",
                        matrix[currentRow][currentCol].equals("0") ? "u" : matrix[currentRow][currentCol]);

            }

            System.out.println();
        }
    }
}
