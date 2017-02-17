import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int priceCount = Integer.parseInt(reader.readLine());
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < priceCount; i++) {
            prices.add(Integer.parseInt(reader.readLine()));
        }

        int[] days = new int[priceCount];
        days[0] = 1;

        for (int i = 1; i < prices.size(); i++) {
            int currentPrice = prices.get(i);
            int maxDays = 1;

            for (int prev = i - 1; prev >= 0; prev--) {
                if (prices.get(prev) > currentPrice){
                    break;
                }
                maxDays++;
            }

            days[i] = maxDays;
        }

        for (int day : days) {
            System.out.println(day + " ");
        }
    }
}
