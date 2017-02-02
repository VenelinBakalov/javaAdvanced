import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBase10ToBaseN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int baseN = Integer.parseInt(input[0]);
        BigInteger base10 = new BigInteger(input[1]);

        StringBuilder resultBaseN = new StringBuilder();

        while (base10.compareTo(new BigInteger("0")) > 0) {
            BigInteger remainder = base10.divideAndRemainder(new BigInteger(baseN + ""))[1];
            BigInteger division = base10.divideAndRemainder(new BigInteger(baseN + ""))[0];
            resultBaseN.insert(0, remainder);
     //     resultBaseN.append(remainder);
            base10 = division;
        }

   //   resultBaseN.reverse();
        System.out.println(resultBaseN);
    }
}
