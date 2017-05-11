package pascalTriangle;

/**
 * Created by Venelin on 9.5.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        int n = 10;
        long[] pascal = new long[n + 1];

        for (int row = 0; row < n; row++) {
            for (int col = row; col >= 0; col--) {
                if (col == 0 || col == row) {
                    pascal[col] = 1;
                } else {
                    pascal[col] = pascal[col] + pascal[col - 1];
                }
                System.out.print(pascal[col] + " ");
            }
            System.out.println();
        }
    }
}
