import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        do {
            int remainder = decimal % 2;
            decimal /= 2;
            stack.push(remainder);
        } while (decimal != 0);

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
