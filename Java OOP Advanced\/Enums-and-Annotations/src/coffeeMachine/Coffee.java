package coffeeMachine;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = CoffeeSize.valueOf(size.toUpperCase());
        this.type = CoffeeType.valueOf(type.toUpperCase());
    }

    public int getPrice() {
        return this.size.getCoins();
    }
}
