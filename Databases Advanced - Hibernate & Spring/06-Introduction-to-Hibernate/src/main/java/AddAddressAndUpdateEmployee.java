import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class AddAddressAndUpdateEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Address address = new Address();
        address.setText("Vitoshka 15");

        Employee nakovkata = (Employee) em
                .createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'").getSingleResult();

        nakovkata.setAddress(address);

        em.getTransaction().begin();
        em.persist(address);
        em.persist(nakovkata);

        em.getTransaction().commit();

        Query query = em.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'");
        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee.getAddress().getText());

        em.close();
        emf.close();

    }
}
