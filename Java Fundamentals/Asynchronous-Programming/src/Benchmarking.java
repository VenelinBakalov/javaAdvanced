import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Benchmarking {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n = ");
        int to = Integer.parseInt(reader.readLine());

        List<Integer> numbers= new ArrayList<>();
        for (int i = 0; i < to; i++) {
            numbers.add(i);
        }

        long start = System.nanoTime();

        ExecutorService es = Executors.newFixedThreadPool(4);
        Future[] results = new Future[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            Future<Boolean> future = es.submit(() -> isPrime(number));
            results[i] = future;
        }

        es.awaitTermination(100L, TimeUnit.MILLISECONDS);

        long totalTime = System.nanoTime() - start;
        System.out.println("Execution time: " + totalTime);
        es.shutdown();
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
