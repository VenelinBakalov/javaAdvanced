package coffeeMachine;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public enum CoffeeSize {
    SMALL(50,50), NORMAL(100, 75), DOUBLE(200, 100);

    private int ml;
    private int coins;

    CoffeeSize(int ml, int coins) {
        this.ml = ml;
        this.coins = coins;
    }

    public int getCoins() {
        return this.coins;
    }
}
