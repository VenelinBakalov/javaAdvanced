import java.util.Scanner;

public class GroupNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersString = scanner.nextLine().split(", ");
        int[] numbers = new int[numbersString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        int[] sizes = new int[3];
        int[] offsets = new int[3];

        for (int number : numbers) {
            int remainder = Math.abs(number) % 3;
            sizes[remainder]++;
        }

        int[][] numbersByRemainder =
                { new int[sizes[0]], new int[sizes[1]], new int[sizes[2]] };

        for (int number : numbers) {
            int remainder = Math.abs(number) % 3;
            int index = offsets[remainder];
            numbersByRemainder[remainder][index] = number;
            offsets[remainder]++;
        }

        for (int[] ints : numbersByRemainder) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
