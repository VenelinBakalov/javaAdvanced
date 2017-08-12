package app.repositories;

import app.entities.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@Repository
public interface AccessoriesRepository extends JpaRepository<Accessory, Long> {
}
