package jarofT;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Venelin on 16.3.2017 г..
 */
public class Jar<T> {

    private Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T element) {
        this.elements.push(element);
    }

    public T remove() {
        return this.elements.pop();
    }
}
