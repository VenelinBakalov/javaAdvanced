import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String employeeName = reader.readLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        try {
            Employee employee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE concat(e.firstName, ' ', e.lastName) = '" + employeeName + "'").getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException e) {
            System.out.println("No");

        }

        em.close();
        emf.close();
    }
}
