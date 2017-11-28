package bg.softuni.model.shop;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class Bazaar extends ShopAbstract<Mall> {

    private static final long MAX_CAPACITY = 30;

    public Bazaar(Mall successor) {
        super(successor, MAX_CAPACITY);
    }
}
