package overloadMethod;

/**
 * Created by Venelin on 2.3.2017 г..
 */
public class MathOperation {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
