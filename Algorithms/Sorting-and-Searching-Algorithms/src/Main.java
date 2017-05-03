import models.SortableCollection;
import models.sorters.BucketSorter;
import models.sorters.InsertionSorter;
import models.sorters.QuickSorter;

import java.util.Random;

/**
 * Created by Venelin on 2.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        SortableCollection<Integer> collection = new SortableCollection<>(2, -1, 5, 0, -3);
        System.out.println(collection);

        collection.sort(new InsertionSorter<>());
        System.out.println(collection);

        Random random = new Random();

        int elementsToSort = 100;
        int maxValue = 999;

        Integer[] array = new Integer[elementsToSort];

        for (int i = 0; i < elementsToSort; i++) {
            array[i] = random.nextInt(maxValue);
        }

        SortableCollection<Integer> collectionToSort = new SortableCollection<>(array);
        collectionToSort.sort(new BucketSorter(maxValue));

        System.out.println(collectionToSort);
    }
}
