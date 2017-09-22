package linkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class CustomLinkedList<T> implements Iterable<T> {

    private List<T> data;

    public CustomLinkedList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public boolean remove(T element) {
        for (int i = 0; i < this.data.size(); i++) {
            T currentElement = this.data.get(i);
            if (currentElement.equals(element)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return this.data.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator();
    }

    private final class CustomLinkedListIterator implements Iterator<T> {
        private int counter;

        private CustomLinkedListIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < data.size();
        }

        @Override
        public T next() {
            return data.get(counter++);
        }
    }
}
