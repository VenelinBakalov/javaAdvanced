package products_shop.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.app.dto.bind.add.UserAddDto;
import products_shop.app.dto.view.UserDto;
import products_shop.app.dto.view.UserDtoViewSold;
import products_shop.app.dto.view.UserDtoViewSoldProducts;
import products_shop.app.dto.view.UserDtoViewWrapper;
import products_shop.app.entities.User;
import products_shop.app.repos.UserRepositery;
import products_shop.app.utils.ModelParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepositery userRepositery;

    @Autowired
    public UserServiceImpl(UserRepositery userRepositery) {
        this.userRepositery = userRepositery;
    }

    @Override
    public void registerUser(UserAddDto user) {
        User userToReg = ModelParser.map(user, User.class);
        if (userToReg != null) {
            this.userRepositery.save(userToReg);
        }

    }

    @Override
    public List<UserDto> findAll() {
        List<User> all = this.userRepositery.findAll();
        List<UserDto> users=new ArrayList<>();
        for (User user : all) {
            UserDto maped = ModelParser.map(user, UserDto.class);

            users.add(maped);

        }
        return users;
    }

    @Override
    public List<UserDtoViewSold> findUsersWithSoldProducts() {
        List<User> usersWithSoldProducts = this.userRepositery.findUsersWithSoldProducts();
        List<UserDtoViewSold> usersToShow=new LinkedList<>();
        for (User usersWithSoldProduct : usersWithSoldProducts) {

            usersWithSoldProduct.getSoldProducts().removeIf(product -> product.getBuyer() == null);

            UserDtoViewSold mapped = ModelParser.map(usersWithSoldProduct, UserDtoViewSold.class);
            usersToShow.add(mapped);

        }


        return usersToShow;


    }

    @Override
    public UserDtoViewWrapper findAllUserByAtLeastOneSell() {
        List<User> allUserByAtLeastOneSell = this.userRepositery.findAllUserByAtLeastOneSell();
        List<UserDtoViewSoldProducts> usersToShow=new LinkedList<>();
        for (User user : allUserByAtLeastOneSell) {
            UserDtoViewSoldProducts userToShow=ModelParser.map(user,UserDtoViewSoldProducts.class);
            usersToShow.add(userToShow);
        }
        UserDtoViewWrapper info=new UserDtoViewWrapper();
        info.setUserDtoViewSoldProducts(usersToShow);
        info.setUsersCount();
        return info;
    }
}
