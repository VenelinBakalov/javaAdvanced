package app.repositories;

import app.entities.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Repository
public interface PhotographersRepository extends JpaRepository<Photographer, Long> {

    Photographer findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT p FROM Photographer as p inner join p.lenses as l where l.focalLength <= 30 order by p.firstName asc")
    List<Photographer> findPhotographersWithSmallLens();
}
