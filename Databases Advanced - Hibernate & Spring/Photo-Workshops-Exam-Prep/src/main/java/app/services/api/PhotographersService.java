package app.services.api;

import app.dto.photographers.PhotographerImportJsonDto;
import app.entities.Photographer;

import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
public interface PhotographersService {

    Photographer add(PhotographerImportJsonDto photographer);
    List<Photographer> findLandscapePhotographers();
}
