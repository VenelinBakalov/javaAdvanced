package products_shop.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import products_shop.app.entities.Product;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepositery extends JpaRepository<Product, Long> {

    List<Product> findProductsByBuyerIsNullAndPriceBetweenOrderByPriceAsc(BigDecimal price, BigDecimal price2);


}
