package contracts;

import java.util.List;

/**
 * Created by Venelin on 2.5.2017 г..
 */
public interface Sorter<T extends Comparable<T>> {

    void sort(List<T> collection);
}
