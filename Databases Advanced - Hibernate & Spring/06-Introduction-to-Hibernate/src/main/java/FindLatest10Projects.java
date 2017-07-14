import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class FindLatest10Projects {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Project> projects = em
                .createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC , p.name ASC ")
                .setMaxResults(10)
                .getResultList();

        projects
                .stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.println(String.format("-- Name: %s Description: %s Start date: %s End date: %s",
                    p.getName(),
                    p.getDescription(),
                    p.getStartDate(),
                    p.getEndDate())));

        em.close();
        emf.close();
    }
}
