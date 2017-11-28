package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public abstract class CustomCollection {

    private List<String> collection;

    protected CustomCollection() {
        this.collection = new ArrayList<>();
    }

    protected List<String> getCollection() {
        return this.collection;
    }
}
