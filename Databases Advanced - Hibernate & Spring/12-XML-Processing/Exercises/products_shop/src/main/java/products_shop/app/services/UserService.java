package products_shop.app.services;

import products_shop.app.dto.bind.add.UserAddDto;
import products_shop.app.dto.view.UserDto;
import products_shop.app.dto.view.UserDtoViewSold;
import products_shop.app.dto.view.UserDtoViewWrapper;

import java.util.List;



public interface UserService {
     void registerUser(UserAddDto user);
     List<UserDto> findAll();

     List<UserDtoViewSold> findUsersWithSoldProducts();

     UserDtoViewWrapper findAllUserByAtLeastOneSell();
}
