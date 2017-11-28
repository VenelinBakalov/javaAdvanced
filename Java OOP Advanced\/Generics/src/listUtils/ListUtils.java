package listUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 16.3.2017 г..
 */
public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }

        T min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }

        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static List<Integer> getNullIndices(List<?> list) {
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> src) {
        for (List<? extends T> inner : src) {
            dest.addAll(inner);
        }
    }

    public static <T> void addAll(List<? super T> dest, List<? extends T> source) {
        for (T element : source) {
            dest.add(element);
        }
    }
}
