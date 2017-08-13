package app.repositories;

import app.entities.Employee;
import app.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByCard(EmployeeCard card);

    @Query("SELECT e FROM Employee AS e INNER JOIN e.branch as b WHERE b.id IN (SELECT b.id FROM Product as p inner join p.branch as pb where pb.id = b.id) ")
    List<Employee> findAllProductiveEmployees();
}
