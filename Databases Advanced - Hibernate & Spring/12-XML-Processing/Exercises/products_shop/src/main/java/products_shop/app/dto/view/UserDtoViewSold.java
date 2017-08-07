package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

import java.util.Set;


public class UserDtoViewSold {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Set<ProductDtoViewSold> soldProducts;

    public UserDtoViewSold() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductDtoViewSold> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductDtoViewSold> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
