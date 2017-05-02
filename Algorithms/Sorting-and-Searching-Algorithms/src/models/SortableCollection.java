package models;

import contracts.Sorter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 2.5.2017 г..
 */
public class SortableCollection<T extends Comparable<T>> {

    private List<T> items;

    public SortableCollection() {
        this.items = new ArrayList<>();
    }

    public SortableCollection(Iterable<T> items) {
        this();
        items.forEach(this.items::add);
    }

    public SortableCollection(T... items) {
        this.items = Arrays.asList(items);
    }

    public int count() {
        return this.items.size();
    }

    public void sort(Sorter<T> sorter) {
        sorter.sort(this.items);
    }

    public int binarySearch(T item) {
        return 0;
    }

    public int interpolationSearch(T item) {
        return 0;
    }

    public void shuffle() {

    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (this.count() == 0) {
            throw new IllegalStateException("Collection empty");
        }
        Class<?> elementType = this.items.getClass().getComponentType();
        T[] elements = (T[]) Array.newInstance(elementType, this.count());
        return this.items.toArray(elements);
    }

    @Override
    public String toString() {
        return String.join(", ", this.items.stream().map(Object::toString).collect(Collectors.toList()));
    }
}
