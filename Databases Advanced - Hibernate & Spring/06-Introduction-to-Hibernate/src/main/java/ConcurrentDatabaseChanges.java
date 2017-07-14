import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class ConcurrentDatabaseChanges {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        em.getTransaction().begin();
        Employee testEmployee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE e.id = 3").getSingleResult();
        testEmployee.setLastName("ConcurrentTest");

        em2.getTransaction().begin();
        Employee secondTestEmployee = (Employee) em2.createQuery("SELECT e FROM Employee AS e WHERE e.id = 3").getSingleResult();
        secondTestEmployee.setMiddleName("NewNameAfterTest");

        em.getTransaction().commit();
        em2.getTransaction().commit();

        em.close();
        em2.close();
        emf.close();
    }
}
