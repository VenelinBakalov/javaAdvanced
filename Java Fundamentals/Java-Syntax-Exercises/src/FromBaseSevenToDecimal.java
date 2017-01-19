import java.util.Scanner;

public class FromBaseSevenToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        char[] number = scanner.nextLine().toCharArray();

        int[] reverse = new int[number.length];

        for (int i = 0; i < number.length; i++) {
            reverse[i] = Integer.parseInt(String.valueOf(number[number.length - 1 - i]));
        }

        for (int i = 0; i < reverse.length; i++) {
            result += reverse[i] * Math.pow(7, i);
        }

        System.out.println(result);
    }
}
