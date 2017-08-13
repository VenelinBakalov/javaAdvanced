package app.repositories;

import app.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Integer> {

    EmployeeCard findByNumber(String number);


    @Query("SELECT c FROM EmployeeCard as c WHERE c.id NOT IN (SELECT e.card.id FROM Employee AS e) ORDER BY c.id ASC ")
    List<EmployeeCard> findAllUnusedCards();

}
