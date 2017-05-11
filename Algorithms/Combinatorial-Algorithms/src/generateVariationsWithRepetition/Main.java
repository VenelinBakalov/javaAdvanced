package generateVariationsWithRepetition;


/**
 * Created by Venelin on 5.5.2017 г..
 */
public class Main {

    private static final int N = 10;
    private static final int K = 3;
    private static int[] arr = new int[K];

    public static void main(String[] args) {
        generateVariationsRecursive(0);
        generateVariationsIterative();
    }

    private static void generateVariationsIterative() {
        while (true) {
            print(arr);
            int index = K - 1;

            while (index >= 0 && arr[index] == N - 1) {
                index--;
            }

            if (index < 0) {
                break;
            }

            arr[index]++;

            for (int i = index + 1; i < K; i++) {
                arr[i] = 0;
            }
        }
    }

    private static void generateVariationsRecursive(int index) {
        if (index >= K) {
            print(arr);
        } else {
            for (int i = 0; i < N; i++) {
                arr[index] = i;
                generateVariationsRecursive(index + 1);
            }
        }
    }

    private static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number);
        }
        System.out.println();
    }
}
