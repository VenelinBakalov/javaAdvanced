package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entities.Album;

/**
 * Created by Venelin on 24.7.2017 г..
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
