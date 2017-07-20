import dependencyContainer.EntityManagerFactoryContainer;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Venelin on 19.7.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactoryContainer.getInstance();
        emf.close();
    }
}
