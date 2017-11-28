package customListExer;

import customList.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 21.3.2017 г..
 */
public class CustomListIml<T extends Comparable<T>> implements CustomList<T>{

    private List<T> data;

    public CustomListIml() {
        this.data = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        this.data.add(element);
    }

    @Override
    public T remove(int index) {
        return this.data.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.data.contains(element);
    }

    @Override
    public void swap(int fromIndex, int toIndex) {
        T firstElement = this.data.get(fromIndex);
        T secondElement = this.data.get(toIndex);
        this.data.set(fromIndex, secondElement);
        this.data.set(toIndex, firstElement);
    }

    @Override
    public int countGreaterThan(T element) {
        return (int)this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    @Override
    public T getMax() {
        T currentElement = this.data.get(0);
        for (T item : data) {
            if (item.compareTo(currentElement) > 0) {
                currentElement = item;
            }
        }
        return currentElement;
    }

    @Override
    public T getMin() {
        T currentElement = this.data.get(0);
        for (T item : data) {
            if (item.compareTo(currentElement) < 0) {
                currentElement = item;
            }
        }
        return currentElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : data) {
            sb.append(item).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
