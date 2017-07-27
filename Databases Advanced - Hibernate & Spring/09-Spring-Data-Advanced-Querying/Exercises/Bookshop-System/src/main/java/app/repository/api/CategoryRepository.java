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


    @Query("select c.name, sum(b.copies * b.price) from Category as c inner join c.books as b group by c.name " +
            "order by sum(b.copies * b.price) desc, c.name asc")
    List<Object[]> findTotalProfitByCategory();

//    @Query("select c.name, b.title from Category as c inner join c.books as b where b.id in (select b.id from Book inner join b.categories as bc where bc.id = c.id order by b.releaseDate desc limit 3)")
//    List<Object[]> findRecentBooksByCategories();

    @Query("select c from Category as c inner join c.books as b group by c having count(b) > 35 order by count(b) desc ")
    List<Category> findAllCategoriesOrderByBookCount();
}
