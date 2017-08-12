package app.repositories;

import app.entities.BasicCamera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Repository
public interface CamerasRepository extends JpaRepository<BasicCamera, Long> {
}
