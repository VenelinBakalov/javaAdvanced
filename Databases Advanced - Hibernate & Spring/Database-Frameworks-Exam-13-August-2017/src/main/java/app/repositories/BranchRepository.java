package app.repositories;

import app.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

    Branch findByName(String name);

    @Query("SELECT b FROM Branch as b where b.town.name = :townName")
    List<Branch> findByTownName(@Param("townName") String townName);
}
