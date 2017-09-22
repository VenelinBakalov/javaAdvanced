package cardGameExer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 27.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player firstPlayer = new Player(reader.readLine());
        Player secondPlayer = new Player(reader.readLine());
        Deck deck = new Deck();

        Class crd = Class.forName("cardGameExer." + reader.readLine());
        if (crd.isAnnotationPresent(CardInfo.class)) {
           CardInfo crdInfo = (CardInfo) crd.getAnnotation(CardInfo.class);
            System.out.println(crdInfo.description());
        }

   //    CardInfo crd = null;
   //    switch (reader.readLine()) {
   //        case "Rank":
   //            crd = Rank.class.getAnnotation(CardInfo.class);
   //            System.out.println(crd.description());
   //            break;
   //        case "Suit":
   //            crd = Suit.class.getAnnotation(CardInfo.class);
   //            System.out.println(crd.description());
   //            break;
   //    }

        while (firstPlayer.getSize() < 5) {
            try {
                firstPlayer.addCard(deck.getCard(reader.readLine()));
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        while (secondPlayer.getSize() < 5) {
            try {
                secondPlayer.addCard(deck.getCard(reader.readLine()));
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        Player winner = getWinner(firstPlayer, secondPlayer);
        System.out.println(String.format("%s wins with %s.", winner.getName(), winner.getHighestCard()));
    }

    private static Player getWinner(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer.getHighestCard().compareTo(secondPlayer.getHighestCard()) > 0) {
            return firstPlayer;
        }
        return secondPlayer;
    }
}
