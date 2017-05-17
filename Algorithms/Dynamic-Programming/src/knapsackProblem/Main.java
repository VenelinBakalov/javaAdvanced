package knapsackProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 17.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(5, 30),
                new Item(8, 120),
                new Item(7, 10),
                new Item(0, 20),
                new Item(4, 50),
                new Item(5, 80),
                new Item(2, 10)
        };

        int knapsackCapacity = 20;

        List<Item> itemsTaken = fillKnapsack(items, knapsackCapacity);

        System.out.println(String.join("\n", itemsTaken.stream().map(Object::toString).collect(Collectors.toList())));
    }

    private static List<Item> fillKnapsack(Item[] items, int capacity) {
        int[][] maxPrice = new int[items.length][capacity + 1];
        boolean[][] isItemTaken = new boolean[items.length][capacity + 1];

        for (int c = 0; c < capacity + 1; c++) {
            if (items[0].getWeight() <= c) {
                maxPrice[0][c] = items[0].getPrice();
                isItemTaken[0][c] = true;
            }
        }

        for (int i = 1; i < maxPrice.length; i++) {
            for (int c = 0; c < maxPrice[i].length; c++) {
                // Not taking the item, just saving previous optimal solution
                maxPrice[i][c] = maxPrice[i - 1][c];

                int remainingCapacity = c - items[i].getWeight();
                // Taking the item
                if (remainingCapacity >= 0 &&
                        items[i].getPrice() + maxPrice[i - 1][remainingCapacity] > maxPrice[i - 1][c]) {
                    maxPrice[i][c] = items[i].getPrice() + maxPrice[i - 1][remainingCapacity];
                    isItemTaken[i][c] = true;
                }
            }
        }

        // Reconstruction
        List<Item> itemsTaken = new ArrayList<>();
        int index = items.length - 1;
        while (index >= 0) {
            if (isItemTaken[index][capacity]) {
                itemsTaken.add(items[index]);
                capacity -= items[index].getWeight();
            }

            index--;
        }

        return itemsTaken;
    }
}
