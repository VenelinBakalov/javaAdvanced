package products_shop.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.app.dto.bind.add.ProductAddDto;
import products_shop.app.dto.view.ProductDtoAdapter;
import products_shop.app.dto.view.ProductViewDto;
import products_shop.app.dto.view.xml.ProductsExportXMLDto;
import products_shop.app.entities.Product;
import products_shop.app.repos.ProductRepositery;
import products_shop.app.utils.ModelParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepositery productRepositery;

    @Autowired
    public ProductServiceImpl(ProductRepositery productRepositery) {
        this.productRepositery = productRepositery;
    }


    @Override
    public void register(ProductAddDto product) {
        Product productToSave = ModelParser.map(product, Product.class);
        if (productToSave!=null){
            this.productRepositery.save(productToSave);
        }
    }

    @Override
    public List<ProductViewDto> findProductsByPrice(BigDecimal price, BigDecimal price2) {
        List<Product> products = this.productRepositery.findProductsByBuyerIsNullAndPriceBetweenOrderByPriceAsc(price, price2);
        List<ProductViewDto> productsToShow=new ArrayList<>();

        for (Product product : products) {
            ProductDtoAdapter productDtoAdapter=ModelParser.map(product,ProductDtoAdapter.class);
            ProductViewDto productDtoView = ModelParser.map(productDtoAdapter,ProductViewDto.class);
            productsToShow.add(productDtoView);
        }


        return productsToShow;
    }

    @Override
    public List<ProductViewDto> findAll() {
        List<Product> products = this.productRepositery.findAll();
        List<ProductViewDto> productViewDtos = new ArrayList<>();
        for (Product product : products) {
            ProductViewDto productViewDto = ModelParser.getInstance().map(product, ProductViewDto.class);
            productViewDtos.add(productViewDto);
        }
        return productViewDtos;
    }

    @Override
    public ProductsExportXMLDto getProductsToExport() {
        ProductsExportXMLDto productsExportXMLDto = new ProductsExportXMLDto();
        productsExportXMLDto.setProductViewDtos(this.findAll());
        return productsExportXMLDto;
    }
}
