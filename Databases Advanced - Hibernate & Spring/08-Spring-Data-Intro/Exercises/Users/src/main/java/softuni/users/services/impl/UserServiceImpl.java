package softuni.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.users.entities.User;
import softuni.users.repositories.UserRepository;
import softuni.users.services.api.UserService;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 22.7.2017 г..
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
    public void persist(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<Object[]> findUsersByEmailProvider(String provider) {
        return this.userRepository.findUsersByEmailProvider(provider);
    }

    @Override
    public Integer prepareInactiveUsersForRemoval(Date date) {
        return this.userRepository.prepareInactiveUsersForRemoval(date);
    }

    @Override
    public void deleteInactiveUsers() {
        this.userRepository.deleteInactiveUsers();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Integer countByProfilePictureGreaterThan(byte[] length) {
        return userRepository.countByProfilePictureGreaterThan(length);
    }
}
