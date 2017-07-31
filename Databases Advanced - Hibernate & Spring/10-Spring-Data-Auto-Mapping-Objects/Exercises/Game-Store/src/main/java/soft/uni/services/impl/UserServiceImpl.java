package soft.uni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soft.uni.entities.User;
import soft.uni.entities.api.UserType;
import soft.uni.enums.Role;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.models.bindingModels.user.ShoppingCartUser;
import soft.uni.utils.ModelParser;
import soft.uni.models.bindingModels.user.RegisterUser;
import soft.uni.repositories.UserRepository;
import soft.uni.services.api.UserService;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public <T extends UserType> void persist(T userToPersist) {
        User user = ModelParser.getInstance().map(userToPersist, User.class);

        if (userToPersist instanceof RegisterUser) {
            if (this.userRepository.findAll().size() > 0) {
                user.setRole(Role.USER);
            } else {
                user.setRole(Role.ADMIN);
            }
        }

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public LoggedInUser findByEmailAndPassword(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password);
        LoggedInUser loggedInUser = null;

        if (user != null) {
            loggedInUser = ModelParser.getInstance().map(user, LoggedInUser.class);
        }

        return loggedInUser;
    }

    @Override
    public <T> T findById(Long id, Class<T> userType) {
        User user = this.userRepository.findById(id);
        if (user == null) return null;
        return ModelParser.getInstance().map(user, userType);
    }
}
