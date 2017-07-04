package lastDigitName;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Number {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public String getLastDigitName() {
        int lastDigit = this.number % 10;

        switch (lastDigit) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }
}
