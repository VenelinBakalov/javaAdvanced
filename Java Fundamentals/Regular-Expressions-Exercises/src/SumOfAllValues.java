import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keysRegex = "^(?<startKey>[a-zA-Z_]+)[\\d](.*?[\\d])?(?<endKey>[a-zA-Z_]+)$";
        Pattern keyPattern = Pattern.compile(keysRegex);

        String numberRegex = "([\\d]+(\\.\\d+)?(?!\\.))";
        Pattern numberPattern = Pattern.compile(numberRegex);

        String keys = reader.readLine();
        String text = reader.readLine();

        Matcher matchKeys = keyPattern.matcher(keys);

        if (!matchKeys.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String startKey = matchKeys.group("startKey");
        String endKey = matchKeys.group("endKey");

        BigDecimal totalValue = new BigDecimal(0 + "");

        Pattern matchPattern = Pattern.compile(startKey + "([\\d]+(\\.\\d+)?(?!\\.))" + endKey);
        Matcher patternMatch = matchPattern.matcher(text);
        while (patternMatch.find()) {
            String match = patternMatch.group();
            Matcher numbers = numberPattern.matcher(match);

            while (numbers.find()) {
                totalValue = totalValue.add(new BigDecimal(numbers.group() + ""));
            }
        }

        if (totalValue.equals(new BigDecimal(0))) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            System.out.println(String.format("<p>The total value is: <em>%s</em></p>", totalValue));
        }

    }
}
