package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.users.entities.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 22.7.2017 г..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.username, u.email from User as u where u.email like concat('%', :provider)")
    List<Object[]> findUsersByEmailProvider(@Param("provider") String provider);

    @Query("update User as u set u.deleted = true where u.lastTimeLoggedIn < :date")
    @Modifying
    Integer prepareInactiveUsersForRemoval(@Param("date") Date date);

    @Query("delete from User as u where u.deleted = true")
    @Modifying
    void deleteInactiveUsers();

    Integer countByProfilePictureGreaterThan(byte[] length);
}
