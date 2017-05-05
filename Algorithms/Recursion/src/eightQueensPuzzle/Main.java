package eightQueensPuzzle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venelin on 5.5.2017 г..
 */
public class Main {

    private static final int SIZE = 8;
    private static final int LEFT_DIAGONAL_POSITIVE_ADJUST = 7;
    private static boolean[][] chessboard = new boolean[SIZE][SIZE];
    private static boolean[] attackedColumns = new boolean[8];
    private static boolean[] attackedLeftDiagonals = new boolean[15];
    private static boolean[] attackedRightDiagonals = new boolean[15];
    private static int solutionsFound = 0;

    public static void main(String[] args) {
        putQueens(0);
        System.out.println(solutionsFound);
    }

    private static void putQueens(int row) {
        if (row == SIZE) {
            printSolution();
        } else {
            for (int col = 0; col < SIZE; col++) {
                if (canPlaceQueen(row, col)) {
                    markAllAttackedPositions(row, col);
                    putQueens(row + 1);
                    unmarkAllAttackedPositions(row, col);
                }
            }
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        boolean isPositionOccupied = attackedColumns[col] ||
                attackedLeftDiagonals[col - row + LEFT_DIAGONAL_POSITIVE_ADJUST] ||
                attackedRightDiagonals[row + col];

        return !isPositionOccupied;
    }

    private static void markAllAttackedPositions(int row, int col) {
        attackedColumns[col] = true;
        attackedLeftDiagonals[col - row + LEFT_DIAGONAL_POSITIVE_ADJUST] = true;
        attackedRightDiagonals[row + col] = true;
        chessboard[row][col] = true;
    }

    private static void unmarkAllAttackedPositions(int row, int col) {
        attackedColumns[col] = false;
        attackedLeftDiagonals[col - row + LEFT_DIAGONAL_POSITIVE_ADJUST] = false;
        attackedRightDiagonals[row + col] = false;
        chessboard[row][col] = false;
    }

    private static void printSolution() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(chessboard[row][col] ? "*" : "-");
            }
            System.out.println();
        }
        System.out.println();

        solutionsFound++;
    }
}
