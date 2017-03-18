package customList;

import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 18.3.2017 г..
 */
public class Sorter {

    // Bubble sort try
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        List<T> data = list.getData();
        for (int i = 0; i < data.size(); i++) {
            for (int j = data.size() - 1; j >= i + 1; j--) {
                T currentElement = data.get(j);
                T previousElement = data.get(j - 1);
                if (currentElement.compareTo(previousElement) < 0) {
                    data.set(j - 1, currentElement);
                    data.set(j, previousElement);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void customSort(CustomList<T> list) {
        List<T> data = list.getData();
        for (int i = 0; i < data.size() - 1; i++) {
            T currentElement = data.get(i);
            T nextElement = data.get(i + 1);
            if (currentElement.compareTo(nextElement) > 0 ) {
                data.set(i, nextElement);
                data.set(i + 1, currentElement);
                i = -1;
            }
        }
    }
}
