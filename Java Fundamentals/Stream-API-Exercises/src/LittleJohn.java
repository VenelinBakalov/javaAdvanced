import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    private static final String SMALL = "small";
    private static final String MEDIUM = "medium";
    private static final String LARGE = "large";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([>]{1,3})[-]{5}([>]{1,2})";
        Pattern pattern = Pattern.compile(regex);


        Map<String, Integer> arrows = new LinkedHashMap<>();
        arrows.put(SMALL, 0);
        arrows.put(MEDIUM, 0);
        arrows.put(LARGE, 0);

        for (int i = 0; i < 4; i++) {
            String hay = reader.readLine();
            Matcher matcher = pattern.matcher(hay);
            int start = 0;

            while (matcher.find(start)) {
                int leftSize = matcher.group(1).length();
                int rightSize = matcher.group(2).length();

                if (leftSize == 1 && rightSize == 1 || (leftSize == 1 && rightSize == 2)) {
                    arrows.put(SMALL, arrows.get(SMALL) + 1);
                    start = matcher.end();
                } else if ((leftSize == 2 && rightSize == 1) || (leftSize == 3 && rightSize == 1)) {
                    arrows.put(MEDIUM, arrows.get(MEDIUM) + 1);
                    start = matcher.end();

                } else if (leftSize == 3 && rightSize == 2) {
                    arrows.put(LARGE, arrows.get(LARGE) + 1);
                    start = matcher.end();

                } else {
                    start = matcher.start() + matcher.group(1).length();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        arrows.values().forEach(sb::append);

        String binary = Integer.toBinaryString(Integer.valueOf(sb.toString()));
        String concatenatedBinary = binary + new StringBuilder(binary).reverse();
        int result = Integer.parseInt(concatenatedBinary, 2);

        System.out.println(result);
    }

}
