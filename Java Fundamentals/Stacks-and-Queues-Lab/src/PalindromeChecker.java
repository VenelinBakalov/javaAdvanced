import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (char c : inputLine.toCharArray()) {
            deque.offer(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char firstChar = deque.poll();
            char lastChar = deque.pollLast();

            if (firstChar != lastChar){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}
