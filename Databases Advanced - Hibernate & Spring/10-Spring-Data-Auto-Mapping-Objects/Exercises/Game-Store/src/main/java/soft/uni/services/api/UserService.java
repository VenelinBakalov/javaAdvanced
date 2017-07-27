package soft.uni.services.api;

import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.models.bindingModels.user.RegisterUser;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public interface UserService {

    void persist(RegisterUser user);
    LoggedInUser findByEmailAndPassword(String email, String password);
}
