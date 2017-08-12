package app.services.api;

import app.entities.Lens;

import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
public interface LensService {

    List<Lens> addAll(Iterable<Lens> lenses);
    List<Lens> findByIdIn(Iterable<Long> id);

}
