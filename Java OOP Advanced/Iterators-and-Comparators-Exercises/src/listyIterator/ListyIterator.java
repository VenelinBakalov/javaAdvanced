package listyIterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Venelin on 22.3.2017 г..
 */
public class ListyIterator implements Iterable<String> {

    private List<String> data;
    private int index;

    public ListyIterator(List<String> elements) {
        this.data = elements;
    }

    public boolean move() {
        if (this.index + 1 < this.data.size()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index < this.data.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(data.get(this.index));
    }

    public void printAll() {
        StringBuilder sb = new StringBuilder();
        for (String element : data) {
            sb.append(element).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private final class CustomIterator implements Iterator<String> {
        private int counter;

        private CustomIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return data.size() > counter;
        }

        @Override
        public String next() {
            return data.get(counter++);
        }
    }
}
