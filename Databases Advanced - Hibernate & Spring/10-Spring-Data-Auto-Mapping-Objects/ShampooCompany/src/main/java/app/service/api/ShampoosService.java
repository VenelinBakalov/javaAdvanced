package app.service.api;

import app.model.BasicIngredient;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
public interface ShampoosService<BasicShampoos, Long> extends ServiceInterface<BasicShampoos, Long> {
    List<BasicShampoos> shampoosWithIngredient(String ingredientName);
}
