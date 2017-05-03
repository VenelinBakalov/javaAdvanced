package models.sorters;

import contracts.Sorter;
import models.SortableCollection;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Venelin on 3.5.2017 г..
 */
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public void sort(List<T> collection) {
        if (collection.size() == 0) {
            throw new IllegalStateException("List is empty");
        }

        Class<?> elementsType = collection.get(0).getClass();
        T[] tempArray = (T[]) Array.newInstance(elementsType, collection.size());

        this.mergeSort(collection, tempArray, 0, collection.size() - 1);
    }

    private void mergeSort(List<T> collection, T[] tempArray, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;

            this.mergeSort(collection, tempArray, start, middle);
            this.mergeSort(collection, tempArray, middle + 1, end);

            this.merge(collection, tempArray, start, middle, end);
        }
    }

    private void merge(List<T> collection, T[] tempArray, int start, int middle, int end) {
        int leftMinIndex =  start;
        int rightMinIndex = middle + 1;
        int tempIndex = 0;

        while (leftMinIndex <= middle && rightMinIndex <= end) {
            if (collection.get(leftMinIndex).compareTo(collection.get(rightMinIndex)) <= 0) {
                tempArray[tempIndex++] = collection.get(leftMinIndex++);
            } else {
                tempArray[tempIndex++] = collection.get(rightMinIndex++);
            }
        }

        while (leftMinIndex <= middle) {
            tempArray[tempIndex++] = collection.get(leftMinIndex++);
        }
        while (rightMinIndex <= end) {
            tempArray[tempIndex++] = collection.get(rightMinIndex++);
        }

        tempIndex = 0;
        leftMinIndex = start;

        while (tempIndex < tempArray.length && leftMinIndex <= end) {
            collection.set(leftMinIndex++, tempArray[tempIndex++]);
        }
    }

    public static void main(String[] args) {
        SortableCollection<Integer> collection = new SortableCollection<>(2, -1, 5, 0, -3);
        System.out.println(collection);

        collection.sort(new MergeSorter<>());
        System.out.println(collection);
    }

}
