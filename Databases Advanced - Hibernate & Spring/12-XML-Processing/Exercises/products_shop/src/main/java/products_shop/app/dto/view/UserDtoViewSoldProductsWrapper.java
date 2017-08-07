package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;



public class UserDtoViewSoldProductsWrapper {

    @Expose
    private Long count;

    @Expose
    @SerializedName("products")
    private Set<ProductDtoAdapter> soldProductsSoldProducts;

    public UserDtoViewSoldProductsWrapper() {
    }

    public Long getCount() {
        return (long)this.soldProductsSoldProducts.size();
    }

    public void setCount() {
        this.count = (long)this.soldProductsSoldProducts.size();
    }

    public Set<ProductDtoAdapter> getSoldProductsSoldProducts() {
        return soldProductsSoldProducts;
    }

    public void setSoldProductsSoldProducts(Set<ProductDtoAdapter> soldProductsSoldProducts) {
        this.soldProductsSoldProducts = soldProductsSoldProducts;
        this.setCount();
    }
}
