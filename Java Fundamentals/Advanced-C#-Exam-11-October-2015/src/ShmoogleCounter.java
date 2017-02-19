import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ShmoogleCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> doubles = new ArrayList<>();
        List<String> ints = new ArrayList<>();

        String methodRegex = "\\([^)]*\\)( +)\\{.*?(?<=[^ ])\\1\\}";
        String doubleRegex = "double\\s+([a-z][a-zA-Z]*)";
        String intRegex = "int\\s+([a-z][a-zA-Z]*)";
        Pattern methodPat = Pattern.compile(methodRegex);
        Pattern doublePat = Pattern.compile(doubleRegex);
        Pattern intPat = Pattern.compile(intRegex);

        String codeLine;
        StringBuilder code = new StringBuilder();

        while (!"//END_OF_CODE".equals(codeLine = reader.readLine())) {
            code.append(codeLine);
        }

        Matcher method = methodPat.matcher(code);

        int index = code.indexOf("static void Main()");
        String beforeMain = code.substring(0, index);

        Matcher dobMatch = doublePat.matcher(beforeMain);
        Matcher inMatch = intPat.matcher(beforeMain);

        while (dobMatch.find()) {
            doubles.add(dobMatch.group(1));
        }

        while (inMatch.find()) {
            ints.add(inMatch.group(1));
        }

        while (method.find()) {
            String methodCode = method.group();
            Matcher doubleMatcher = doublePat.matcher(methodCode);
            Matcher intMatcher = intPat.matcher(methodCode);

            Set<String> intSet = new HashSet<>();
            Set<String> doubleSet = new HashSet<>();

            while (doubleMatcher.find()) {
                doubles.add(doubleMatcher.group(1));
            }

            while (intMatcher.find()) {
                ints.add(intMatcher.group(1));
            }

        }

        System.out.println("Doubles: " + (doubles.isEmpty() ? "None" : String.join(", ", doubles.stream().sorted(String::compareTo).collect(Collectors.toList()))));
        System.out.println("Ints: " + (ints.isEmpty() ? "None" : String.join(", ", ints.stream().sorted(String::compareTo).collect(Collectors.toList()))));
    }
}
