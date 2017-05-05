package generatingPermutations;

/**
 * Created by Venelin on 5.5.2017 г..
 */
public class Main {

    private static int[] arr = new int[] { 1, 2, 3, 4 };

    public static void main(String[] args) {
        permutate(arr, 0);
    }

    private static void permutate(int[] arr, int index) {
        if (index >= arr.length) {
            print(arr);
            return;
        }

        permutate(arr, index + 1);
        for (int i = index + 1; i < arr.length; i++) {
            swap(index, i);
            permutate(arr, index + 1);
            swap(index, i);
        }
    }

    private static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number);
        }
        System.out.println();
    }


    private static void swap(int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
