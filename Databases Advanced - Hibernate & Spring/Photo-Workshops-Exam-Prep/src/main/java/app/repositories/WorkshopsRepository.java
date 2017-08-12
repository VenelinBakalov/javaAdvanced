package app.repositories;

import app.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Repository
public interface WorkshopsRepository extends JpaRepository<Workshop, Long> {

    @Query("SELECT distinct w.location FROM Workshop as w ")
    List<String> findAllLocations();

    @Query("SELECT w from Workshop as w inner join w.participants as p WHERE w.location = :location group by w having count (p) >= 5")
    List<Workshop> findWorkshopsByLocation(@Param("location") String location);
}
