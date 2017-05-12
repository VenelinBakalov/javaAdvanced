package moveDownRightSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Venelin on 12.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {

        int[][] cells = {
                {2, 6, 1, 8, 9, 4, 2},
                {1, 8, 0, 3, 5, 6, 7},
                {3, 4, 8, 7, 2, 1, 8},
                {0, 9, 2, 8, 1, 7, 9},
                {2, 7, 1, 9, 7, 8, 2},
                {4, 5, 6, 1, 2, 5, 6},
                {9, 3, 5, 2, 8, 1, 9},
                {2, 3, 4, 1, 7, 2, 8}
        };

        int rowsCount = cells.length;
        int colsCount = cells[0].length;

        int[][] sums = new int[rowsCount][colsCount];
        sums[0][0] = cells[0][0];

        // Set best paths in 0th column
        for (int row = 1; row < sums.length; row++) {
            sums[row][0] = sums[row - 1][0] + cells[row][0];
        }

        // Set best paths in 0th row
        for (int col = 1; col < sums[0].length; col++) {
            sums[0][col] = sums[0][col - 1] + cells[0][col];
        }

        for (int row = 1; row < sums.length; row++) {
            for (int col = 1; col < sums[row].length; col++) {
                sums[row][col] = Math.max(sums[row - 1][col], sums[row][col - 1]) + cells[row][col];
            }
        }

        // Get the best path
        List<int[]> path = reconstructPath(sums);

        // Print the sums
        for (int row = 0; row < sums.length; row++) {
            for (int col = 0; col < sums[row].length; col++) {
                if (path.contains(new int[]{row, col})) {
                    System.out.print("*" + sums[row][col] + "* ");
                } else {
                    System.out.print(sums[row][col] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = path.size() - 1; i >= 0; i--) {
            int[] coords = path.get(i);
            System.out.print(cells[coords[0]][coords[1]] + " ");
        }
    }

    private static List<int[]> reconstructPath(int[][] sums) {

        List<int[]> path = new ArrayList<>();

        int r = sums.length - 1;
        int c = sums[sums.length - 1].length - 1;

        path.add(new int[] { r, c });

        while (r > 0 && c > 0) {
            if (sums[r - 1][c] > sums[r][c - 1]) {
                path.add(new int[]{r - 1, c});
                r--;
            } else {
                path.add(new int[]{r, c - 1});
                c--;
            }
        }

        while (r > 0) {
            path.add(new int[]{r - 1, c});
            r--;
        }

        while (c > 0) {
            path.add(new int[]{r, c - 1});
            c--;
        }

        return path;
    }
}
