package listUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 16.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 2, 3);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 3.5);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);
        System.out.println(dest);

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 18, 1, -1);
        Integer maxInt = ListUtils.getMax(integers);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");
        String minString = ListUtils.getMin(strings);

        System.out.println(maxInt);
        System.out.println(minString);

        List<Integer> integersWithNulls = new ArrayList<>();
        Collections.addAll(integersWithNulls, 1, 2, null, 1, null);
        List<Integer> intNulls = ListUtils.getNullIndices(integersWithNulls);
        System.out.println(intNulls);
    }
}
