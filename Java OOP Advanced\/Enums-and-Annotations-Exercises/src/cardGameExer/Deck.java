package cardGameExer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Venelin on 27.3.2017 г..
 */
public class Deck {

    private Map<String, Card> allCards;

    public Deck() {
        this.allCards = new HashMap<>();
        this.initializeCards();
    }

    public Card getCard(String name) {
        if (!this.allCards.containsKey(name)) {
            throw new IllegalArgumentException("No such card exists.");
        }
        if (this.allCards.get(name) == null) {
            throw new IllegalStateException("Card is not in the deck.");
        }

        Card card = this.allCards.get(name);
        this.allCards.put(name, null);

        return card;
    }

    private void initializeCards() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit);
                this.allCards.put(card.getName(), card);
            }
        }
    }
}
