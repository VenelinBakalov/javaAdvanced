package genericScale;

/**
 * Created by Venelin on 16.3.2017 г..
 */
public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.compareTo(right) < 0) {
            return right;
        }

        if (left.compareTo(right) > 0) {
            return left;
        }

        return null;
    }
}
