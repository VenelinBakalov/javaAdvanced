package generate01Vectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 4.5.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        int[] vector = new int[count];

        gen01(vector, count - 1);
    }

    private static void gen01(int[] vector, int index) {
        if (index == -1) {
            print(vector);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            gen01(vector, index - 1);
        }
    }

    private static void print(int[] vector) {
        for (int element : vector) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
