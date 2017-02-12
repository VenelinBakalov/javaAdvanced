import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> flowers = new ArrayDeque<>();
        Deque<Integer> buckets = new ArrayDeque<>();
        Deque<Integer> secondNatureFlowers = new ArrayDeque<>();

        String[] flowersArgs = reader.readLine().split(" ");
        String[] bucketsArgs = reader.readLine().split(" ");

        for (String flower : flowersArgs) {
            flowers.add(Integer.parseInt(flower));
        }

        for (String bucket : bucketsArgs) {
            buckets.push(Integer.parseInt(bucket));
        }

        while (!flowers.isEmpty() && !buckets.isEmpty()) {
            int flower = flowers.poll();
            int bucket = buckets.pop();
            int difference = bucket - flower;

            if (difference == 0) {
                secondNatureFlowers.add(flower);
            } else if (difference > 0) {
                if (!buckets.isEmpty()) {
                    int nextBucket = buckets.poll();
                    nextBucket += difference;
                    buckets.push(nextBucket);
                }else {
                    buckets.push(difference);
                }
            } else if (difference < 0) {
                flower = Math.abs(difference);
                flowers.push(flower);
            }
        }

        if (flowers.isEmpty()) {
            while (!buckets.isEmpty()) {
                System.out.print(buckets.pop() + " ");
            }

        } else if (buckets.isEmpty()) {
            while (!flowers.isEmpty()) {
                System.out.print(flowers.poll() + " ");
            }
        }

        System.out.println();

        if (secondNatureFlowers.isEmpty()) {
            System.out.println("None");
        } else {
            while (!secondNatureFlowers.isEmpty()) {
                System.out.print(secondNatureFlowers.poll() + " ");
            }
        }
    }
}
