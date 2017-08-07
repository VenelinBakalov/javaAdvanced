package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UserDtoViewWrapper {

    @Expose
    private Long usersCount;

    @Expose
    @SerializedName("users")
    private List<UserDtoViewSoldProducts> userDtoViewSoldProducts;


    public UserDtoViewWrapper() {
    }

    public Long getCount() {
        return (long)this.userDtoViewSoldProducts.size();
    }

    public void setUsersCount() {
        this.usersCount = (long)this.userDtoViewSoldProducts.size();;
    }

    public List<UserDtoViewSoldProducts> getUserDtoViewSoldProducts() {
        return userDtoViewSoldProducts;
    }

    public void setUserDtoViewSoldProducts(List<UserDtoViewSoldProducts> userDtoViewSoldProducts) {
        this.userDtoViewSoldProducts = userDtoViewSoldProducts;
    }
}
