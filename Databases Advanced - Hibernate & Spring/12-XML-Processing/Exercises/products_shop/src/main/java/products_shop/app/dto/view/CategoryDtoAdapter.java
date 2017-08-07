package products_shop.app.dto.view;

import products_shop.app.entities.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;



public class CategoryDtoAdapter {

    private String name;

    private Set<Product> products;

    public CategoryDtoAdapter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Long getCount() {
        return (long)this.products.size();
    }

    public BigDecimal getTotalRevenue() {
        return this.getProducts().stream().map(Product::getPrice).
                reduce(BigDecimal::add).orElse(new BigDecimal("0"));

    }

    public BigDecimal getAveragePrice() {
        return this.getTotalRevenue().divide(BigDecimal.valueOf(this.getCount()), RoundingMode.DOWN);
    }
}
