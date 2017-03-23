package cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Player implements Comparable<Player> {

    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int getHandSize() {
        return this.cards.size();
    }

    public Card getHighestPowerCard() {

        return this.cards.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getPower(), c1.getPower()))
                .limit(1)
                .findFirst()
                .get();

        //  Card card = this.cards.get(0);
        //  for (int i = 1; i < cards.size(); i++) {
        //      if (card.compareTo(cards.get(i)) < 0) {
        //          card = cards.get(i);
        //      }
        //  }
        //  return card;
    }

    @Override
    public int compareTo(Player player) {
        return this.getHighestPowerCard().getPower() - player.getHighestPowerCard().getPower();
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s.", this.name, this.getHighestPowerCard());
    }
}
