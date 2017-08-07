package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;



public class ProductDtoAdapter {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    private UserDtoViewFullName seller;

    public ProductDtoAdapter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserDtoViewFullName getSeller() {
        return seller;
    }

    public void setSeller(UserDtoViewFullName seller) {
        this.seller = seller;
    }
}
