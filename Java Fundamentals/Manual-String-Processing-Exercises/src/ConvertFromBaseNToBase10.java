import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBaseNToBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        BigInteger base = new BigInteger(input[0]);
        StringBuilder sb = new StringBuilder(input[1]).reverse();
        BigInteger numberBase10 = new BigInteger("0");

        for (int i = 0; i < sb.length(); i++) {
            BigInteger currentPow = base.pow(i);
            BigInteger currentNum = new BigInteger(String.valueOf(sb.charAt(i)));
            numberBase10 = numberBase10.add(currentNum.multiply(currentPow));
        }

        System.out.println(numberBase10);
    }
}
