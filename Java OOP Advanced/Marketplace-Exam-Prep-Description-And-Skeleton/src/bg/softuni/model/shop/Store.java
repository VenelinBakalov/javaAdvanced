package bg.softuni.model.shop;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class Store extends ShopAbstract<Bazaar> {

    private static final long MAX_CAPACITY = 15;

    public Store(Bazaar successor) {
        super(successor, MAX_CAPACITY);
    }
}
