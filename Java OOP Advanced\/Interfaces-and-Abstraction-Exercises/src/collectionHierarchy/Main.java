package collectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] elements = reader.readLine().split(" ");

        for (String element : elements) {
            System.out.print(addCollection.add(element) + " ");
        }
        System.out.println();

        for (String element : elements) {
            System.out.print(addRemoveCollection.add(element) + " ");
        }
        System.out.println();

        for (String element : elements) {
            System.out.print(myList.add(element) + " ");
        }
        System.out.println();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(myList.remove() + " ");
        }
    }
}
