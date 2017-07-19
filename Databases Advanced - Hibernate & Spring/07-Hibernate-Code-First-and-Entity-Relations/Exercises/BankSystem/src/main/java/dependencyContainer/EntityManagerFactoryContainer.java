package dependencyContainer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Venelin on 19.7.2017 г..
 */
public class EntityManagerFactoryContainer {
    private static EntityManagerFactory emfInstance;

    public static EntityManagerFactory getInstance() {

        if (emfInstance == null) {
            emfInstance = Persistence.createEntityManagerFactory("BankSystem");
        }

        return emfInstance;
    }

    private EntityManagerFactoryContainer() {};
}
