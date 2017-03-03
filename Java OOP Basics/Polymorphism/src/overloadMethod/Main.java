package overloadMethod;

/**
 * Created by Venelin on 2.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();
        System.out.println(mathOperation.add(2, 2));
        System.out.println(mathOperation.add(3, 3, 3));
        System.out.println(mathOperation.add(4, 4, 4, 4));
    }
}
