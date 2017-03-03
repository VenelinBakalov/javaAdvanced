package bookShop;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price + 0.3 * price);
    }
}
