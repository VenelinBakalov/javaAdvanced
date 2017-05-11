package generateCombinations;

/**
 * Created by Venelin on 9.5.2017 г..
 */
public class Main {

    private static final int K = 3;
    private static final int N = 4;

    private static int[] arr = new int[K];

    public static void main(String[] args) {
        generateCombinations(0, 0);
    }

    private static void generateCombinations(int index, int start) {
        if (index >= K) {
            print(arr);
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[index] = i;

            // generate WITHOUT repetitions
//            generateCombinations(index + 1, i + 1);

            // generate WITH repetitions
            generateCombinations(index + 1, i);
        }
    }


    private static void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number);
        }
        System.out.println();
    }
}
