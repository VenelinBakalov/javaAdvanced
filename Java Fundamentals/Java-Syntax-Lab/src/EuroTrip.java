import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);

        double quantity = scanner.nextDouble();
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInLeva = new BigDecimal(quantity * 1.20);
        BigDecimal totalPrice = priceInLeva.multiply(exchangeRate);

        System.out.printf("%.2f marks", totalPrice);
    }
}
