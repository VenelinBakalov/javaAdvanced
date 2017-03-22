package stackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Venelin on 22.3.2017 г..
 */
public class CustomStack implements Iterable<Integer> {

    List<Integer> data;

    public CustomStack() {
        this.data = new ArrayList<>();
    }

    public void push(Integer... element) {
        this.data.addAll(Arrays.asList(element));
    }

    public int pop() {
        if (this.data.size() <= 0) {
            throw new IllegalStateException("No elements");
        }
        return this.data.remove(this.data.size() - 1);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer> {

        private int counter;

        private StackIterator() {
            this.counter = data.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.counter >= 0;
        }

        @Override
        public Integer next() {
            return data.get(this.counter--);
        }
    }
}
