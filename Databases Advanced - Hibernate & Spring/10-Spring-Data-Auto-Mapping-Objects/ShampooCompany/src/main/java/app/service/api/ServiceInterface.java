package app.service.api;

import java.util.List;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
public interface ServiceInterface<E, K> {

    E findById(K id);

    void remove(E object);

    List<E> findAll (Class<E> object);

    void save (E object);

}
