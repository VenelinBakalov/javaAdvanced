package app.repository.api;

import app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category as c where c.name in :categories")
    Set<Category> categoriesByName(@Param("categories") List<String> categories);
}
