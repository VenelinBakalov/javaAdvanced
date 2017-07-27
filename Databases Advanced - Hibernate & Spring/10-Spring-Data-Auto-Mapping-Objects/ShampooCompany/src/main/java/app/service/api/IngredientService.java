package app.service.api;

import app.model.BasicIngredient;
import app.model.BasicShampoos;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
public interface IngredientService<BasicIngredient, Long> extends ServiceInterface<BasicIngredient, Long> {
    List<app.model.BasicIngredient> findByNameEndsWith (String suffix);
    List<BasicShampoos> shampoosWithIngredient(BasicIngredient ingredient);
}
