import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class RemoveTowns {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townName = reader.readLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Query selectAddresses = em.createQuery("SELECT a FROM Address AS a WHERE a.town.name = :name");
        selectAddresses.setParameter("name", townName);
        List<Address> addressesToRemove = selectAddresses.getResultList();

        em.getTransaction().begin();

        for (Address address : addressesToRemove) {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            em.flush();
            em.remove(address);
        }

        Query selectTown = em.createQuery("SELECT t FROM Town AS t WHERE t.name = :name");
        selectTown.setParameter("name", townName);

        Town town = (Town) selectTown.getSingleResult();
        em.remove(town);

        int deletedCount = addressesToRemove.size();

        System.out.println(String.format("%d address%s in %s %s deleted",
                deletedCount,
                deletedCount == 1 ? "" : "es",
                townName,
                deletedCount == 1 ? "was" : "were"));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
