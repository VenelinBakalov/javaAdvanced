package threeuple;

/**
 * Created by Venelin on 18.3.2017 г..
 */
public class Threeuple<E, T, V> {

    E item1;
    T item2;
    V item3;

    public Threeuple(E item1, T item2, V item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    @Override
    public String toString() {
        return this.getItem1() + " -> " + this.getItem2() + " -> " + this.item3;
    }

    public E getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    public V getItem3() {
        return item3;
    }

    private void setItem1(E item1) {
        this.item1 = item1;
    }

    private void setItem2(T item2) {
        this.item2 = item2;
    }

    private void setItem3(V item3) {
        this.item3 = item3;
    }
}
