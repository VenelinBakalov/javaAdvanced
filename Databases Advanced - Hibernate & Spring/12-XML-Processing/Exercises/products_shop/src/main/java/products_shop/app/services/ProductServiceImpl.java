package products_shop.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.app.dto.bind.add.ProductAddDto;
import products_shop.app.dto.view.ProductDtoAdapter;
import products_shop.app.dto.view.ProductDtoView;
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
    public List<ProductDtoView> findProductsByPrice(BigDecimal price, BigDecimal price2) {
        List<Product> products = this.productRepositery.findProductsByBuyerIsNullAndPriceBetweenOrderByPriceAsc(price, price2);
        List<ProductDtoView> productsToShow=new ArrayList<>();

        for (Product product : products) {
            ProductDtoAdapter productDtoAdapter=ModelParser.map(product,ProductDtoAdapter.class);
            ProductDtoView productDtoView = ModelParser.map(productDtoAdapter,ProductDtoView.class);
            productsToShow.add(productDtoView);
        }


        return productsToShow;
    }
}
