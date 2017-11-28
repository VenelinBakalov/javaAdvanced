package collectionHierarchy;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class AddCollection extends CustomCollection implements Addable {

    @Override
    public int add(String element) {
        super.getCollection().add(element);
        return super.getCollection().size() - 1;
    }
}
