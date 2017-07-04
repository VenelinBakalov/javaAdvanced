package numberInReversedOrder;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class DecimalNumber {
    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public void printReversedNumber() {
        for (int i = number.length() - 1; i >= 0; i--) {
            System.out.print(number.charAt(i));
        }
    }
}
