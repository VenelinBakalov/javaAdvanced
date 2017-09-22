package genericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Venelin on 17.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Box<Double>> boxes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Box<Double> box = new Box<>(Double.valueOf(reader.readLine()));
            boxes.add(box);
        }
        Box<Double> element = new Box<>(Double.valueOf(reader.readLine()));
        System.out.println(getCount(boxes, element));

 //  for (int i = 0; i < count; i++) {
 //      Box<Integer> box = new Box<>(Integer.parseInt(reader.readLine()));
 //      boxes.add(box);
 //  }
 //  int[] swapIndexes = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
 //  swap(boxes, swapIndexes[0], swapIndexes[1]);

 //  boxes.forEach(System.out::println);
    }

    public static <T> void swap(List<T> list, int firstIndex, int secondIndex) {
        T firstElement = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, firstElement);
    }

    public static <T extends Comparable<T>> Integer getCount(List<T> list, T element) {
        int count = 0;
        for (T currentElement : list) {
            if (currentElement.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
