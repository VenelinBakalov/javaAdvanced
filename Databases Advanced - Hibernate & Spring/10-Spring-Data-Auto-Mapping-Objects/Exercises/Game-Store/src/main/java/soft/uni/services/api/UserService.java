package soft.uni.services.api;

import soft.uni.entities.api.UserType;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.models.bindingModels.user.RegisterUser;
import soft.uni.models.bindingModels.user.ShoppingCartUser;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public interface UserService {

    <T extends UserType> void persist(T userToPersist);

    LoggedInUser findByEmailAndPassword(String email, String password);

    <T> T findById(Long id, Class<T> userType);
}
