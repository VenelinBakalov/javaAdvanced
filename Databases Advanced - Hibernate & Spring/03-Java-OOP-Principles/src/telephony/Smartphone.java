package telephony;

/**
 * Created by Venelin on 5.7.2017 г..
 */
public class Smartphone implements Callable, Browsable {
    @Override
    public String call(String number) {
        for (char digit : number.toCharArray()) {
            if (! Character.isDigit(digit)) {
                return "Invalid number!";
            }
        }

        return "Calling... " + number;
    }

    @Override
    public String browse(String website) {
        for (char letter : website.toCharArray()) {
            if (Character.isDigit(letter)) {
                return "Invalid URL!";
            }
        }

        return "Browsing: " + website + "!";
    }
}
