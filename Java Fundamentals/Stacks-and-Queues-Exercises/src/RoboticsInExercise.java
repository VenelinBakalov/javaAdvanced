import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RoboticsInExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(";");

        String[] robots = new String[tokens.length];
        int[] processTime = new int[tokens.length];
        int[] robotCounter = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String[] robotToken = tokens[i].split("-");
            robots[i] = robotToken[0];
            processTime[i] = Integer.parseInt(robotToken[1]);
        }

        String[] timeTokens = scanner.nextLine().split(":");
        long hours = Integer.parseInt(timeTokens[0]) * 60 * 60;
        long minutes = Integer.parseInt(timeTokens[1]) * 60;
        long seconds = Integer.parseInt(timeTokens[2]);
        long time = hours + minutes + seconds;

        Deque<String> products = new ArrayDeque<>();

        String product = "";
        while (!"End".equals(product = scanner.nextLine())) {
            products.offer(product);
        }

        while (!products.isEmpty()) {
            time++;
            for (int i = 0; i < robots.length; i++) {
                if (robotCounter[i] > 0) {
                    robotCounter[i]--;
                }
            }

            String currentProduct = products.poll();
            boolean isProductTaken = false;

            for (int i = 0; i < robots.length; i++) {
                if (robotCounter[i] == 0) {
                    robotCounter[i] = processTime[i];
                    isProductTaken = true;
                    System.out.printf("%s - %s [%s]%n", robots[i], currentProduct, convertSeconds(time));
                    break;
                }
            }

            if (!isProductTaken) {
                products.offer(currentProduct);
            }
        }

    }

    private static String convertSeconds(long time) {
        long hours =(time / (60 * 60)) % 24;
        long minutes = (time / 60) % 60;
        long seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
