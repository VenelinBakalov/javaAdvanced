import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlusRemoveTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<String>> matrix = new ArrayList<>();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("END")) {
            ArrayList<String> currentLine = new ArrayList<>();

            for (int i = 0; i < commandLine.length(); i++) {
                currentLine.add(String.valueOf(commandLine.charAt(i)));
            }

            matrix.add(currentLine);

            commandLine = scanner.nextLine();
        }

        ArrayList<int[]> indexes = new ArrayList<>();

        for (int row = 0; row < matrix.size() - 2; row++) {
            for (int col = 1; col < matrix.get(row).size(); col++) {
                String currentChar = matrix.get(row).get(col);

                try {

                    if (!"".equals(currentChar)
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 1).get(col - 1).toLowerCase())
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 1).get(col).toLowerCase())
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 1).get(col + 1).toLowerCase())
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 2).get(col).toLowerCase())) {
                        indexes.add(new int[]{row, col});
                        indexes.add(new int[]{row + 1, col - 1});
                        indexes.add(new int[]{row + 1, col});
                        indexes.add(new int[]{row + 1, col + 1});
                        indexes.add(new int[]{row + 2, col});

                    }
                } catch (Exception error) {

                }
            }
        }

            for (int[] index : indexes) {
                matrix.get(index[0]).set(index[1], "");
            }

            for (ArrayList<String> strings : matrix) {
                for (String string : strings) {
                    if (!string.isEmpty()) {
                        System.out.print(string);
                    }
                }
                System.out.println();
            }
        }
    }
