import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Venelin on 19.7.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vehicles");
        emf.close();
    }
}
