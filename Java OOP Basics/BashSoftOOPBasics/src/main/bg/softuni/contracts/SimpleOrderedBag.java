package main.bg.softuni.contracts;

import java.util.Collection;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public interface SimpleOrderedBag<E extends Comparable<E>> extends Iterable<E> {

    boolean remove(E element);

    int capacity();

    void add(E element);

    void addAll(Collection<E> elements);

    int size();

    String joinWith(String joiner);

}
