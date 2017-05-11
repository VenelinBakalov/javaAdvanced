package generateVariationsWithNoRepetitions;

/**
 * Created by Venelin on 5.5.2017 г..
 */
public class Main {

    private static final int N = 4;
    private static final int K = 2;
    private static int[] arr = new int[K];
    private static boolean[] used = new boolean[N];
    private static int[] free = new int[N];

    public static void main(String[] args) {
        generateVariationsNoRep(0);

        for (int i = 0; i < N; i++) {
            free[i] = i;
        }
        generateVariationsNoRepOptimized(0);
    }

    private static void generateVariationsNoRep(int index) {
        if (index >= K) {
            print(arr);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (! used[i]) {
                used[i] = true;
                arr[index] = i;
                generateVariationsNoRep(index + 1);
                used[i] = false;
            }
        }
    }

    private static void generateVariationsNoRepOptimized(int index) {
        if (index >= K) {
            print(arr);
            return;
        }

        for (int i = index; i < N; i++) {
            arr[index] = free[i];
            swap(i, index);
            generateVariationsNoRepOptimized(index + 1);
            swap(i, index);
        }
    }

    private static void swap(int i, int index) {
        int temp = free[i];
        free[i] = free[index];
        free[index] = temp;
    }

    private static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number);
        }
        System.out.println();
    }
}
