import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robots = scanner.nextLine().split(";");
        String[] names = new String[robots.length];
        int[] proccessingTime = new int[robots.length];

        for (int i = 0; i < robots.length; i++) {
            String[] robotInfo = robots[i].split("-");
            names[i] = robotInfo[0];
            proccessingTime[i] = Integer.parseInt(robotInfo[1]);
        }

        String[] startTime = scanner.nextLine().split(":");
        long startSeconds = Integer.parseInt(startTime[0]) * 60 * 60 + Integer.parseInt(startTime[1]) * 60 + Integer.parseInt(startTime[2]);

        Deque<String> products = new ArrayDeque<>();

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.add(product);
            product = scanner.nextLine();
        }

        // make 2 queues for robots and seconds, when checking time remove seconds and if > 0 seconds--, if == 0 next product
        //hours = seconds / 3600 % 24;
    }
}
