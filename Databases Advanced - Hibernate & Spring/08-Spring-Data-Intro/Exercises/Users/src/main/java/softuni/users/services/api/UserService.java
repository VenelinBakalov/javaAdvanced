package softuni.users.services.api;

import softuni.users.entities.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 22.7.2017 г..
 */
public interface UserService {

    void persist(User user);
    List<Object[]> findUsersByEmailProvider(String provider);

    Integer prepareInactiveUsersForRemoval(Date date);

    void deleteInactiveUsers();

    List<User> findAll();

    Integer countByProfilePictureGreaterThan(byte[] length);

}
