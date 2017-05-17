package knapsackProblem;

/**
 * Created by Venelin on 17.5.2017 г..
 */
public class Item {

    private int weight;
    private int price;

    public Item(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("weight: %d, price: %d", this.weight, this.price);
    }
}
