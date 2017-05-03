package models.sorters;

import contracts.Sorter;
import models.SortableCollection;

import java.util.List;

/**
 * Created by Venelin on 3.5.2017 г..
 */
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> collection) {
        for (int i = 1; i < collection.size(); i++) {
            int targetIndex = i;

            while (targetIndex > 0 && collection.get(targetIndex - 1).compareTo(collection.get(targetIndex)) > 0) {
                this.swap(collection, targetIndex - 1, targetIndex);
                targetIndex--;
            }
        }
    }

    private void swap(List<T> collection, int i, int targetIndex) {
        T temp = collection.get(i);
        collection.set(i, collection.get(targetIndex));
        collection.set(targetIndex, temp);
    }

    public static void main(String[] args) {
        SortableCollection<Integer> collection = new SortableCollection<>(2, -1, 5, 0, -3);
        System.out.println(collection);

        collection.sort(new InsertionSorter<>());
        System.out.println(collection);
    }
}
