package products_shop.app.services;

import products_shop.app.dto.bind.add.ProductAddDto;

import products_shop.app.dto.view.ProductDtoView;

import java.math.BigDecimal;
import java.util.List;



public interface ProductService {
    void register(ProductAddDto product);

    List<ProductDtoView> findProductsByPrice(BigDecimal price, BigDecimal price2);

}
