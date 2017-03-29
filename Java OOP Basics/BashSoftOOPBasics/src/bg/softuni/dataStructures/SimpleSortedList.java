package bg.softuni.dataStructures;

import bg.softuni.contracts.SimpleOrderedBag;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public class SimpleSortedList<E extends Comparable<E>> implements SimpleOrderedBag<E> {
    private static final int DEFAULT_SIZE = 16;

    private E[] innerCollection;
    private int size;
    private Comparator<E> comparator;

    public SimpleSortedList(Class<E> type, Comparator<E> comparator, int capacity) {
        this.initializeInnerCollection(type, capacity);
        this.comparator = comparator;
    }

    public SimpleSortedList(Class<E> type, int capacity) {
        this(type, Comparable::compareTo, capacity);
    }

    public SimpleSortedList(Class<E> type, Comparator<E> comparator) {
        this(type, comparator, DEFAULT_SIZE);
    }

    public SimpleSortedList(Class<E> type) {
        this(type, Comparable::compareTo, DEFAULT_SIZE);
    }

    @Override
    public void add(E element) {
        if (this.size() >= this.innerCollection.length) {
            this.resize();
        }

        this.innerCollection[this.size()] = element;
        this.size++;
        Arrays.sort(this.innerCollection, 0, this.size(), this.comparator);
    }

    @Override
    public void addAll(Collection<E> elements) {
        if (this.size() + elements.size() >= this.innerCollection.length) {
            this.multiResize(elements);
        }

        for (E element : elements) {
            this.innerCollection[this.size()] = element;
            this.size++;
        }

        Arrays.sort(this.innerCollection, 0, this.size(), this.comparator);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String joinWith(String joiner) {
        StringBuilder output = new StringBuilder();
        for (E e : this) {
            output.append(e);
            output.append(joiner);
        }

        output.setLength(output.length() - joiner.length());
        return output.toString();
    }


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return innerCollection[this.index++];
            }
        };

        return iterator;
    }

    @SuppressWarnings("unchecked")
    private void initializeInnerCollection(Class<E> type, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }

        this.innerCollection = (E[]) Array.newInstance(type, capacity);
    }

    private void resize() {
        E[] newCollection = Arrays.copyOf(this.innerCollection, this.innerCollection.length * 2);
        this.innerCollection = newCollection;
    }

    private void multiResize(Collection<E> elements) {
        int newSize = this.innerCollection.length * 2;
        while (this.size() + elements.size() >= newSize) {
            newSize *= 2;
        }

        E[] newCollection = Arrays.copyOf(this.innerCollection, newSize);
        this.innerCollection = newCollection;
    }

    private void bubbleSort() {
        for (int i = 0; i <= this.size(); i++) {
            for (int j = this.size() - 1; j >= i + 1; j--) {
                E currentElement = innerCollection[j];
                E previousElement = innerCollection[j - 1];
                if (previousElement.compareTo(currentElement) > 0) {
                    innerCollection[j - 1] = currentElement;
                    innerCollection[j] = currentElement;
                }
            }
        }
    }
}
