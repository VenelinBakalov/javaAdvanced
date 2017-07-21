package app.service.api;

import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
public interface ServiceInterface<E, K> {

    E findById(K id);

    void remove(E object);

    List<E> findAll();

    void save(E object);
}
