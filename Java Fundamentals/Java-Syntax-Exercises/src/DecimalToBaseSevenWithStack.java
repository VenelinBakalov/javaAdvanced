import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBaseSevenWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        do {
            stack.push(decimal % 2);
            decimal /= 2;
        } while (decimal != 0);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
