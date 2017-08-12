package app.services.api;

import app.entities.Accessory;

import java.util.List;

/**
 * Created by Venelin on 13.8.2017 г..
 */
public interface AccessoriesService {

    List<Accessory> addAll(Iterable<Accessory> accessories);
}
