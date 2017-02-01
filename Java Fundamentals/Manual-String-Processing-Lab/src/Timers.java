import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Timers {
    private static StringBuilder sb = new StringBuilder();
    private static String whitespace = " ";
    private static String resultWithConcat = "";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

//      long startTime = System.nanoTime();

//      for (int i = 0; i < count; i++) {
//          String word = reader.readLine();
//          sb.append(word);
//          sb.append(whitespace);
//      }
//      long endTime = System.nanoTime();

//      System.out.println(sb);
//      System.out.println(endTime - startTime);

        long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            String word = reader.readLine();
            resultWithConcat += word + whitespace;
        }

        long endTime = System.nanoTime();

        System.out.println(resultWithConcat);
        System.out.println(endTime - startTime);
    }
}
