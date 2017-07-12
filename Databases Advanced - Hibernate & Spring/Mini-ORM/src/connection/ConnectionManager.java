package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public final class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/miniORMDB?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private ConnectionManager() {};

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
