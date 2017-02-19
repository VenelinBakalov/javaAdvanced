import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResponsiveUI {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Runnable task = () -> primesInRange(10000000);
        Thread thread = new Thread(task);
        thread.start();

        while (true) {
            String command = reader.readLine();

            if (command.equals("stop")) {
                thread.interrupt();
                break;
            } else {
                System.out.println("unknown command");
            }
        }
    }

    public static void primesInRange(int number) {
        List<Integer> primes = new ArrayList<>();

        for (int primeCandidate = 0; primeCandidate <= number; primeCandidate++) {
            if (isPrime(primeCandidate)) {
                primes.add(primeCandidate);
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted...");
                break;
            }
        }
        System.out.println(primes.stream()
                .limit(10)
                .collect(Collectors.toList()) + "...");
        System.out.println("Primes found: " + primes.size());
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
