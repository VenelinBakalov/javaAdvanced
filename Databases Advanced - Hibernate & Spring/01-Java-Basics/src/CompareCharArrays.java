import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 27.6.2017 г..
 */
public class CompareCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstArray = reader.readLine().split(" ");
        String[] secondArray = reader.readLine().split(" ");
        int minLength = Math.min(firstArray.length, secondArray.length);

        for (int i= 0; i < minLength; i++) {
            if (firstArray[i].compareTo(secondArray[i]) < 0) {
                System.out.println(String.join("", firstArray));
                System.out.println(String.join("", secondArray));
                return;
            } else if (firstArray[i].compareTo(secondArray[i]) > 0) {
                System.out.println(String.join("", secondArray));
                System.out.println(String.join("", firstArray));
                return;
            }
        }

        if (firstArray.length > secondArray.length) {
            System.out.println(String.join("", secondArray));
            System.out.println(String.join("", firstArray));

        } else {
            System.out.println(String.join("", firstArray));
            System.out.println(String.join("", secondArray));
        }
    }
}
