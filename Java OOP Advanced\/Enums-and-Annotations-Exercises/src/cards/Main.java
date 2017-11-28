package cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Card> deck = new HashMap<>();

        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardSuit, cardRank);
                deck.put(card.toString(), card);
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        while (firstPlayer.getHandSize() < 5) {
            String[] cardArgs = reader.readLine().split(" of ");
            fillPlayerHand(deck, firstPlayer, cardArgs);
        }

        while (secondPlayer.getHandSize() < 5) {
            String[] cardArgs = reader.readLine().split(" of ");
            fillPlayerHand(deck, secondPlayer, cardArgs);
        }

        if (firstPlayer.compareTo(secondPlayer) > 0) {
            System.out.println(firstPlayer);
        } else {
            System.out.println(secondPlayer);
        }
    }

    private static void fillPlayerHand(Map<String, Card> deck, Player player, String[] cardArgs) {
        String rank = cardArgs[0];
        String suit = cardArgs[1];

        try {
            Card card = new Card(CardSuit.valueOf(suit), CardRank.valueOf(rank));
            if (!deck.containsKey(card.toString())) {
                System.out.println("Card is not in the deck.");
                return;
            }

            player.addCard(card);
            deck.remove(card.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("No such card exists.");
        }
    }

//  public static void main(String[] args) throws IOException {
//      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//      String classType = reader.readLine();
//      Class<?> cardClass = null;
//      switch (classType) {
//          case "Rank":
//              cardClass = CardRank.class;
//              break;
//          case "Suit":
//              cardClass = CardSuit.class;
//              break;
//      }
//      Enumeration annotation = cardClass.getAnnotation(Enumeration.class);
//      System.out.println(String.format("Type = Enumeration, Description = %s", annotation.description()));
//      System.out.println(annotation.annotationType());
//  }
}
