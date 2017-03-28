package cardGameExer;

/**
 * Created by Venelin on 27.3.2017 г..
 */
@CardInfo(category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suit {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    private Suit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
