import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        ArrayDeque<Character> reversed = new ArrayDeque<>();

        for (char c : inputLine.toCharArray()) {
            reversed.push(c);
        }

        while (!reversed.isEmpty()){
            System.out.print(reversed.pop());
        }
    }
}
