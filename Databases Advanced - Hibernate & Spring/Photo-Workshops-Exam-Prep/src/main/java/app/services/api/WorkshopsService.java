package app.services.api;

import app.entities.Workshop;

import java.util.List;
import java.util.Map;

/**
 * Created by Venelin on 12.8.2017 г..
 */
public interface WorkshopsService {

    Workshop add(Workshop workshop);
    Map<String, List<Workshop>> findWorkshopsByLocation();
}
