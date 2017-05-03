package models.sorters;

import contracts.Sorter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 3.5.2017 г..
 */
public class BucketSorter implements Sorter<Integer> {

    private double maxValue;

    public BucketSorter(double maxValue) {
        this.maxValue = maxValue;
    }



    @Override
    public void sort(List<Integer> collection) {
        this.bucketSort(collection);
    }

    @SuppressWarnings("unchecked")
    private void bucketSort(List<Integer> collection) {
        List<Integer>[] buckets = new List[collection.size()];

        for (Integer element : collection) {
            int bucketIndex = (int) (element / this.maxValue * collection.size());

            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new ArrayList<>();
            }

            buckets[bucketIndex].add(element);
        }

        QuickSorter<Integer> sorter = new QuickSorter<>();

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            sorter.sort(buckets[i]);
        }

        int index = 0;

        for (List<Integer> bucket : buckets) {
            if (bucket == null) continue;

            for (Integer element : bucket) {
                collection.set(index++, element);
            }
        }
    }
}
