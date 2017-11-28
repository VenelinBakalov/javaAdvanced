package genericArrayCreator;

import java.lang.reflect.Array;

/**
 * Created by Venelin on 16.3.2017 г..
 */
public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T item) {

        T[] array = (T[]) new Object[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> currentClass, int lenght, T item) {
        T[] array = (T[]) Array.newInstance(currentClass, lenght);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }

        return array;
    }
}
