package app.dao.api;

import app.model.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
public interface IngredientsDao extends JpaRepository<BasicIngredient, Long>, IngedientsDaoCustom {
    List<BasicIngredient> findByNameEndingWith (String suffix);
}
