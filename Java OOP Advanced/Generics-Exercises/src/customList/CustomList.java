package customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 17.3.2017 г..
 */
public class CustomList<T extends Comparable> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<T>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        for (T currentElement : data) {
            if (currentElement.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    public void swap(int index, int secondIndex) {
        T firstElement = this.data.get(index);
        this.data.set(index, this.data.get(secondIndex));
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T currentElement : data) {
            if (currentElement.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            T currentElement = this.data.get(i);
            if (currentElement.compareTo(max) > 0) {
                max = currentElement;
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            T currentElement = this.data.get(i);
            if (currentElement.compareTo(min) < 0) {
                min = currentElement;
            }
        }
        return min;
    }

    public List<T> getData() {
        return this.data;
    }
}
