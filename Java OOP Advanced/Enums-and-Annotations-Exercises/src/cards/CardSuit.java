package cards;

/**
 * Created by Venelin on 23.3.2017 г..
 */
@Enumeration(category = "Suit", description = "Provides suit constants for a Card class.")
public enum CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    CardSuit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
