package app.repositories;

import app.entities.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Repository
public interface LensRepository extends JpaRepository<Lens, Long> {

    List<Lens> findByIdIn(Iterable<Long> id);
}
