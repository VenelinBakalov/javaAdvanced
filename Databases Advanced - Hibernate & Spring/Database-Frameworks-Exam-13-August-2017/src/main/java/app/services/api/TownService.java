package app.services.api;

import app.entities.Town;

import java.util.List;

public interface TownService {

    String add(Town town);
    Town findByName(String name);
    List<Town> findAll();
}
