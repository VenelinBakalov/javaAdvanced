package findPathsInLabyrinth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 5.5.2017 г..
 */
public class Main {

    private static char[][] labyrinth = {
            {' ', ' ', ' ', '*', ' ', ' ', ' '},
            {'*', '*', ' ', '*', ' ', '*', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '*', '*', '*', '*', '*', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'e'}

    };

    private static List<Character> steps = new ArrayList<>();

    public static void main(String[] args) {
        findPathToExit(0, 0, 'S');
    }

    private static void findPathToExit(int row, int col, char direction) {

        if (! isInRange(row, col)) {
            return;
        }

        if (labyrinth[row][col] == 'e') {
            printSolution();
            return;
        }

        if (labyrinth[row][col] != ' ') {
            return;
        }

        labyrinth[row][col] = '.';
        steps.add(direction);

        findPathToExit(row - 1, col, 'U');
        findPathToExit(row, col + 1, 'R');
        findPathToExit(row + 1, col, 'D');
        findPathToExit(row, col - 1, 'L');

        labyrinth[row][col] = ' ';
        steps.remove(steps.size() - 1);
    }

    private static void printSolution() {
        for (int row = 0; row < labyrinth.length; row++) {
            for (int col = 0; col < labyrinth[row].length; col++) {
                System.out.print(labyrinth[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println(String.join(" ", steps.stream().map(Object::toString).collect(Collectors.toList())));
    }

    private static boolean isInRange(int row, int col) {
        boolean rowInRange = row >= 0 && row < labyrinth.length;
        boolean colInRange = col >= 0 && col < labyrinth[0].length;
        return rowInRange && colInRange;
    }
}
