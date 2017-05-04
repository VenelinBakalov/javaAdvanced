package findSum;

/**
 * Created by Venelin on 4.5.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] { 5, 2, 1, 15, 6};

        System.out.println(findSum(array, 0));
    }

    private static int findSum(int[] array, int index) {
        if (index == array.length) return 0;

        return array[index] + findSum(array, index + 1);
    }
}
