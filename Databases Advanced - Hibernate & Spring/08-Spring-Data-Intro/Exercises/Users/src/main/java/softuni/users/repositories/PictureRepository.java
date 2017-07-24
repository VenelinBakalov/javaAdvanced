package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entities.Picture;

/**
 * Created by Venelin on 24.7.2017 г..
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
