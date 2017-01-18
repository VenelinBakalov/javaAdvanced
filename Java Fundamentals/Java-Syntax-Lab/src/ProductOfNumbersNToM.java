import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbersNToM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        int index = firstNumber;
        BigInteger product = BigInteger.ONE;

        do {
 //        product = product.multiply(new BigInteger(String.valueOf(index)));
            BigInteger numberBig = new BigInteger("" + index);
            product = product.multiply(numberBig);
            index++;
        } while (index <= secondNumber);

        System.out.printf("product[%s..%s] = %s\n", firstNumber, secondNumber, product);
    }
}
