package entityManager;

import java.sql.SQLException;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public interface DBContext {

    <E> boolean persist(E entity) throws IllegalAccessException, SQLException, NoSuchFieldException;

    void closeConnection();
}
