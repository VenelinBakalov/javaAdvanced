package products_shop.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import products_shop.app.entities.Category;
import products_shop.app.entities.Product;

import java.util.List;


@Repository
public interface CategoryRepositery extends JpaRepository<Category, Long> {


//    @Query("SELECT c.name,c.products.size ,AVG (p.price),SUM(p.price) FROM Category AS c " +
//            " INNER JOIN c.products AS p " +
//            " group by c.id " +
//            " ORDER BY C.products.size DESC")

    @Query("select c FROM Category AS c ORDER BY c.products.size DESC ")
    List<Category> findAllOrderedByProductCount();

}
