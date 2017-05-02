package models.sorters;

import contracts.Sorter;

import java.util.List;

/**
 * Created by Venelin on 2.5.2017 г..
 */
public class Quicksorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> collection) {
        this.quicksortHoarePartitioning(collection, 0, collection.size() - 1);
    }

    //TODO check for sort with pivot at middle index

    // Up to 3 times faster than Lomuto
    private void quicksortHoarePartitioning(List<T> items, int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = this.partition(items, start, end);

        quicksortHoarePartitioning(items, start, partitionIndex);
        quicksortHoarePartitioning(items, partitionIndex + 1, end);
    }

    private int partition(List<T> items, int start, int end) {
        T pivot = items.get(start);
        int left = start - 1;
        int right = end + 1;

        while (true) {
            do {
                right--;
            } while (items.get(right).compareTo(pivot) > 0);

            do {
                left++;
            } while (items.get(left).compareTo(pivot) < 0);

            if (left < right) {
                this.swap(items, left, right);
            }

            return right;
        }

    }

    private void quicksortLomutoPartitioning(List<T> items, int start, int end) {
        if (start >= end) {
            return;
        }
        T pivot = items.get(start);
        int storeIndex = start + 1;

        for (int i = start + 1; i <= end; i++) {
            if (items.get(i).compareTo(pivot) < 0) {
                this.swap(items, i, storeIndex);
                storeIndex++;
            }
        }

        storeIndex--;

        this.swap(items, start, storeIndex);
        this.quicksortLomutoPartitioning(items, start, storeIndex);
        this.quicksortLomutoPartitioning(items, storeIndex + 1, end);
    }

    private void swap(List<T> items, int i, int storeIndex) {
        T temp = items.get(i);
        items.set(i, items.get(storeIndex));
        items.set(storeIndex, temp);
    }
}
