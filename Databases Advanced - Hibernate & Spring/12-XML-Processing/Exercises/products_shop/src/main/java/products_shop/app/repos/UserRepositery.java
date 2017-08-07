package products_shop.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import products_shop.app.entities.User;

import java.util.List;


@Repository
public interface UserRepositery extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User AS u " +
            " INNER  JOIN u.soldProducts AS p " +
            " WHERE u.soldProducts.size>0 AND p.buyer IS NOT NULL " +
            " GROUP BY u.id " +
            "  " +
            "  ORDER BY u.lastName ASC, u.firstName ASC ")
    List<User> findUsersWithSoldProducts();


    @Query("SELECT u FROM User AS u INNER JOIN u.soldProducts AS p " +
            " WHERE p.buyer IS NOT NULL " +
            " GROUP BY u.id " +
            " ORDER BY u.soldProducts.size DESC, u.lastName ASC ")
    List<User> findAllUserByAtLeastOneSell();
}
