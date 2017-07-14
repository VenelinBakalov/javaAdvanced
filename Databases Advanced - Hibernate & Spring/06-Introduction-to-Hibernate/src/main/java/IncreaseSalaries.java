import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class IncreaseSalaries {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Employee> employees = em
                .createQuery("SELECT e FROM Employee AS e WHERE e.department.name IN ('Engineering', 'Tool Design', " +
                        "'Marketing', 'Information Services')").getResultList();

        em.getTransaction().begin();

        employees.forEach(e -> {
            e.setSalary(e.getSalary().multiply(new BigDecimal(1.12)));
            em.persist(e);
        });

        em.getTransaction().commit();

        employees.forEach(e -> {
            System.out.println(String.format("%s %s ($%.2f)",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getSalary()));
        });

        em.close();
        emf.close();
    }
}
