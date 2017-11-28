package telephony;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Smartphone implements Callable, Browsable {

    @Override
    public String call(String number) {
        for (char digit : number.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return "Invalid number!";
            }
        }
        return "Calling... " + number;
    }

    @Override
    public String browse(String website) {
        for (char letters : website.toCharArray()) {
            if (Character.isDigit(letters)) {
                return "Invalid URL!";
            }
        }
        return "Browsing: " + website + "!";
    }
}
