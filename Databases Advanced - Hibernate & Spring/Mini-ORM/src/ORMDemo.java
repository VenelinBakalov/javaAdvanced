import entityManager.DBContext;
import entityManager.EntityManager;
import model.User;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public class ORMDemo {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        DBContext em = new EntityManager();

        try {
            User user1 = new User("Ivan", 25, LocalDate.now());
            em.persist(user1);
        } finally {
            em.closeConnection();
        }
    }
}
