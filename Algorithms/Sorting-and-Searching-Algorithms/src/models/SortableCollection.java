package models;

import contracts.Sorter;
import models.sorters.InsertionSorter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        this();
        for (T item : items) {
            this.items.add(item);
        }
//        this.items = Arrays.asList(items);
    }

    public int count() {
        return this.items.size();
    }

    public void sort(Sorter<T> sorter) {
        sorter.sort(this.items);
    }

    public int binarySearch(T item) {
        return this.binarySearchProcedure(item, 0, this.items.size() - 1);
    }

    @SuppressWarnings("unchecked")
    public int interpolationSearch(T item) {
        if (this.items.size() == 0) return -1;

        Class<?> collectionType = this.items.get(0).getClass();

        if (collectionType != Integer.class) {
            throw new IllegalStateException("Interpolation search is implemented only for Integer class");
        }

        int key = (Integer) item;
        List<Integer> collection = (List<Integer>) this.items;
        int low = 0;
        int high = this.items.size() - 1;

        while (collection.get(low).compareTo(key) <= 0 && collection.get(high).compareTo(key) >= 0) {
            int mid = low + ((key - collection.get(low)) * (high - low)) / (collection.get(high) - collection.get(low));

            if (collection.get(mid) < key) {
                low = mid + 1;
            } else if (collection.get(mid) > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        if (collection.get(low) == key) {
            return low;
        } else {
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    public void shuffle() {
        Random random = new Random();

        int size = this.items.size();

        for (int i = 0; i < size; i++) {
            int randomPosition = i + random.nextInt(size - i);
            T temp = this.items.get(i);
            this.items.set(i, this.items.get(randomPosition));
            this.items.set(randomPosition, temp);
        }
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (this.count() == 0) {
            throw new IllegalStateException("Collection empty");
        }
        Class<?> elementType = this.items.get(0).getClass();
        T[] elements = (T[]) Array.newInstance(elementType, this.count());
        return this.items.toArray(elements);
    }

    @Override
    public String toString() {
        return String.join(", ", this.items.stream().map(Object::toString).collect(Collectors.toList()));
    }

    private int binarySearchProcedure(T item, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int midpoint = startIndex + (endIndex - startIndex) / 2;

        if (this.items.get(midpoint).compareTo(item) > 0) {
            return this.binarySearchProcedure(item, startIndex, midpoint - 1);
        }

        if (this.items.get(midpoint).compareTo(item) < 0) {
            return this.binarySearchProcedure(item, midpoint + 1, endIndex);
        }

        return midpoint;
    }

    // Test interpolation search
    public static void main(String[] args) {
        SortableCollection<Integer> collection = new SortableCollection<>(2, -1, 5, 0, -3, 50, 12, 100, 132, 525, 22, 60, 80);
        System.out.println(collection);

        collection.sort(new InsertionSorter<>());
        System.out.println(collection);
        System.out.println(collection.interpolationSearch(80));

        System.out.println(collection.toArray()[1]);

        collection.shuffle();
        System.out.println(collection);
    }
}
