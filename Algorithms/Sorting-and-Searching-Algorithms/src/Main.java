import models.SortableCollection;
import models.sorters.Quicksorter;

/**
 * Created by Venelin on 2.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        SortableCollection<Integer> collection = new SortableCollection<>(2, -1, 5, 0, -3);
        System.out.println(collection);

        collection.sort(new Quicksorter<>());
        System.out.println(collection);
    }
}
