import java.util.ArrayList;
import java.util.Scanner;

public class FromDecimalToBaseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberInDecimal = Integer.parseInt(scanner.nextLine());

        String numberInBase7 = "";

        if (numberInDecimal == 0){
            numberInBase7 = String.valueOf(0 % 7);
            System.out.println(numberInBase7);
            return;
        }
        while (numberInDecimal != 0){
            int remainder = numberInDecimal % 7;
            numberInDecimal /= 7;
            numberInBase7 = remainder + numberInBase7;
        }

        System.out.println(numberInBase7);
    }
}
