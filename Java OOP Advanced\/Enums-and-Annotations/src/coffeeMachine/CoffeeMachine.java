package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class CoffeeMachine {

    private List<Coffee> coffeesSold;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(size, type);
        int totalCoins = this.coins.stream().mapToInt(Coin::getValue).sum();
        if (totalCoins > coffee.getPrice()) {
            this.coffeesSold.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin) {
        Coin currentCoin = Coin.valueOf(coin.toUpperCase());
        this.coins.add(currentCoin);
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeesSold;
    }
}
