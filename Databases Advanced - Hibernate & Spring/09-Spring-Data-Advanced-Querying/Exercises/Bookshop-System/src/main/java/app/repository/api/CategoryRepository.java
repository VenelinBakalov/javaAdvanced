package app.repository.api;

import app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
