import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class RemoveObjects {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Town> towns = em
                .createQuery("SELECT t FROM Town AS t")
                .getResultList();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }
        }

//        for (Town town : towns) {
//            if (em.contains(town)) {
//                town.setName(town.getName().toLowerCase());
//                em.persist(town);
//            }
//        }

        em.getTransaction().begin();

        towns.stream().filter(em::contains).forEach(town -> {
            town.setName(town.getName().toLowerCase());
            em.persist(town);
        });

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
