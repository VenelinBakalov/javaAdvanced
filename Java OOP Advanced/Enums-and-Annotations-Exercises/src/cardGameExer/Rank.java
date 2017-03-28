package cardGameExer;

/**
 * Created by Venelin on 27.3.2017 г..
 */
@CardInfo(category = "Rank", description = "Provides rank constants for a Card class.")
public enum Rank {

    ACE(14), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int power;

    private Rank(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
