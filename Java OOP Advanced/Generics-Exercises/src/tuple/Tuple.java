package tuple;

/**
 * Created by Venelin on 18.3.2017 г..
 */
public class Tuple<E, T> {

    E item1;
    T item2;

    public Tuple(E item1, T item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2;
    }

    public E getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    private void setItem1(E item1) {
        this.item1 = item1;
    }

    private void setItem2(T item2) {
        this.item2 = item2;
    }
}
