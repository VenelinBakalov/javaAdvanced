import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Venelin on 15.7.2017 г..
 */
public class FindEmployeesByFirstName {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern = reader.readLine() + "%";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Query findEmployeesQuery = em
                .createQuery("SELECT e FROM Employee AS e WHERE e.firstName like :pattern");
        findEmployeesQuery.setParameter("pattern", pattern);

        List<Employee> employees = findEmployeesQuery.getResultList();

        employees.forEach(e -> {
            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getJobTitle(),
                    e.getSalary()));
        });

        em.close();
        emf.close();
    }
}
