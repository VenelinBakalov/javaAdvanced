package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;


public class UserDtoViewSoldProducts {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private UserDtoViewSoldProductsWrapper soldProducts;

    public UserDtoViewSoldProducts() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserDtoViewSoldProductsWrapper getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(UserDtoViewSoldProductsWrapper soldProducts) {
        this.soldProducts = soldProducts;
    }
}
