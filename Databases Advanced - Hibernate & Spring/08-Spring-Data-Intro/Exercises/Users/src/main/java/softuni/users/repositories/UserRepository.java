package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entities.User;

/**
 * Created by Venelin on 22.7.2017 г..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
