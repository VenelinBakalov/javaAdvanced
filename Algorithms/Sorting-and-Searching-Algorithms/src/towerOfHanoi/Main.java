package towerOfHanoi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Venelin on 4.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {

        Deque<Integer> source = new ArrayDeque<>();

        source.push(3);
        source.push(2);
        source.push(1);

        Deque<Integer> spare = new ArrayDeque<>();
        Deque<Integer> destination = new ArrayDeque<>();

        move(3, source, destination, spare);

        while (!destination.isEmpty()) {
            System.out.println(destination.pop());
        }
    }

    static void move(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {

        if (disk < 1) return;
        // Move all up disks to spare
        move(disk - 1, source, spare, destination);

        // Move current disk to destination
        destination.push(disk);
        source.pop();

        // Move all disks from spare to destination
        move(disk - 1, spare, destination, source);
    }
}
