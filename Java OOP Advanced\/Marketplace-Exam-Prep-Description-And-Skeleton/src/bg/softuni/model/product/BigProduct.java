package bg.softuni.model.product;

/**
 * Created by Venelin on 9.4.2017 г..
 */
public class BigProduct extends ProductAbstract {

    private static final double SIZE_MODIFIER = 2;

    public BigProduct(int id, int size, String name) {
        super(id, size, name);
    }

    @Override
    public void setSize(int size) {
        super.setSize((int) (size * SIZE_MODIFIER));
    }
}
