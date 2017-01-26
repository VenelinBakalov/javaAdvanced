import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();

        for (char aChar : chars) {
            if (!symbolsCount.containsKey(aChar)) {
                symbolsCount.put(aChar, 0);
            }
            symbolsCount.put(aChar, symbolsCount.get(aChar) + 1);
        }

        for (Character character : symbolsCount.keySet()) {
            System.out.println(character + ": " + symbolsCount.get(character) + " time/s");
        }
    }
}
