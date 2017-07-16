import entityManager.DBContext;
import entityManager.EntityManager;
import model.User;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public class ORMDemo {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchFieldException {
        DBContext em = new EntityManager();

        try {
            User user1 = new User("Ivan", 25, LocalDate.now());
            em.persist(user1);
            user1.setAge(26);
            em.persist(user1);
            user1.setName("Gosho");
            user1.setAge(50);
            em.persist(user1);

        } finally {
            em.closeConnection();
        }
    }
}
