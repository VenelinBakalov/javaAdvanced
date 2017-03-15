package collectionHierarchy;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class MyList extends CustomCollection implements Addable, Removable, Usable {

    @Override
    public int used() {
        return super.getCollection().size();
    }

    @Override
    public int add(String element) {
        super.getCollection().add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return super.getCollection().remove(0);
    }
}
