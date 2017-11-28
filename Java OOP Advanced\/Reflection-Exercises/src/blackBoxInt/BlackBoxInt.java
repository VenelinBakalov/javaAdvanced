package blackBoxInt;

/**
 * Created by Venelin on 28.3.2017 г..
 */
public class BlackBoxInt {

    private int innerValue;

    private BlackBoxInt(int innerValue) {
        this.innerValue = innerValue;
    }

    private void add(int added) {
        this.innerValue += added;
    }

    private void subtract(int subtracted) {
        this.innerValue -= subtracted;
    }

    private void multiply(int multiplier) {
        this.innerValue *= multiplier;
    }

    private void divide(int divider) {
        this.innerValue /= divider;
    }

    private void leftShift(int shifter) {
        this.innerValue <<= shifter;
    }

    private void rightShift(int shifter) {
        this.innerValue >>= shifter;
    }
}
