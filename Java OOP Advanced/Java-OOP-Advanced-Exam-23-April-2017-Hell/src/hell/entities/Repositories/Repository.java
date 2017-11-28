package hell.entities.Repositories;

import java.util.Collection;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public interface Repository<T> {

    void add(T element);

    void remove(T element);

    T get(String elementName);

    Collection<T> getAll();
}
