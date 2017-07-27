package app.dao.api;

import app.model.BasicIngredient;
import app.model.BasicShampoos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Repository
public interface ShampoosDao extends JpaRepository<BasicShampoos, Long> {
    @Query("Select s from BasicShampoos s join s.ingredients i where i.name = :ingredientName")
    List<BasicShampoos> shampoosWithIngredient(@Param("ingredientName") String ingredientName);
}
