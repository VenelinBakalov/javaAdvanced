package products_shop.app.services;

import products_shop.app.dto.bind.add.ProductAddDto;

import products_shop.app.dto.view.ProductViewDto;
import products_shop.app.dto.view.xml.ProductsExportXMLDto;

import java.math.BigDecimal;
import java.util.List;



public interface ProductService {
    void register(ProductAddDto product);

    List<ProductViewDto> findProductsByPrice(BigDecimal price, BigDecimal price2);
    List<ProductViewDto> findAll();
    ProductsExportXMLDto getProductsToExport();
}
