import java.util.Scanner;

public class BaseSevenToDecimalWithMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseSeven = scanner.nextLine();

        String decimal = Integer.toString(Integer.parseInt(baseSeven, 7), 10);

        System.out.println(decimal);

        // other option is directly with Integer.parseInt(number as string, base in which the number is).
        // The result is the decimal representation of the number.

        // int result = Integer.parseInt(baseSeven, 7);

        // System.out.println(result);
    }
}
