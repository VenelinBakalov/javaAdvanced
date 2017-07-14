import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Employee employee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE e.id = 4").getSingleResult();
        employee.setFirstName(employee.getFirstName().toUpperCase());

        em.getTransaction().begin();
        em.refresh(employee);
        em.persist(employee);

        em.getTransaction().commit();

        System.out.println(employee.getFirstName());

        em.close();
        emf.close();
    }
}
