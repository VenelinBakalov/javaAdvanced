import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> playerHands = new LinkedHashMap<>();

        while (true) {
            String[] playerHand = scanner.nextLine().split(":\\s+");

            if ("JOKER".equals(playerHand[0])) {
                break;
            }

            String name = playerHand[0];
            HashSet<String> cards = new HashSet<>();
            cards.addAll(Arrays.asList(playerHand[1].split(",\\s+")));

            if (!playerHands.containsKey(name)) {
                playerHands.put(name, cards);
            } else {
                playerHands.get(name).addAll(cards);
            }

        }

        LinkedHashMap<String, Integer> scores = new LinkedHashMap<>();

        for (String player : playerHands.keySet()) {
            int score = 0;
            for (String card : playerHands.get(player)) {
                char power = card.charAt(0);
                char type = card.charAt(card.length() - 1);

                score += (getPowerValue(power) * getTypeValue(type));
            }

            scores.put(player, score);
        }

        for (String player : scores.keySet()) {
            System.out.println(player + ": " + scores.get(player));
        }
    }

    private static int getTypeValue(char type) {
        int power = 0;
        switch (type) {
            case 'S':
                power = 4;
                break;
            case 'H':
                power = 3;
                break;
            case 'D':
                power = 2;
                break;
            case 'C':
                power = 1;
                break;
        }
        return power;
    }

    private static int getPowerValue(char power) {
        int value = 0;
        switch (power){
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                value += Integer.parseInt(String.valueOf(power));
                break;
            case '1':
                value += 10;
                break;
            case 'J':
                value += 11;
                break;
            case 'Q':
                value += 12;
                break;
            case 'K':
                value += 13;
                break;
            case 'A':
                value += 14;
                break;

        }
        return value;
    }
}
