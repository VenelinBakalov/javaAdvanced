import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanProblemPro {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int priceCount = Integer.parseInt(reader.readLine());
        int[] prices = new int[priceCount];

        for (int i = 0; i < priceCount; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
        }

        String[] days = new String[priceCount];
        Deque<Integer> pricesIndex = new ArrayDeque<>();
        days[0] ="1";
        pricesIndex.push(0);

        for (int i = 1; i < priceCount; i++) {
            int maxDays = 1;

            while (pricesIndex.size() > 0 && prices[pricesIndex.peek()] <= prices[i]) {
                pricesIndex.pop();
            }

            if (pricesIndex.isEmpty()) {
                maxDays = i + 1;
            } else {
                maxDays = i - pricesIndex.peek();
            }

            pricesIndex.push(i);
            days[i] = String.valueOf(maxDays);
        }

        System.out.println(String.join("\r\n", days));
    }
}
