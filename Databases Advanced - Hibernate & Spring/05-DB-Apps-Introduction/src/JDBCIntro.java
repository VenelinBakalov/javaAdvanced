import java.sql.*;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public class JDBCIntro {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemodb?createDatabaseIfNotExist=true";
    //Replace with your user name
    private static final String USER = "root";
    //Replace with your password
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection established successfully");

            try(Statement statement = connection.createStatement()) {
                String query = "CREATE TABLE IF NOT EXISTS `users` (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "username VARCHAR(20)," +
                        "password VARCHAR(20))";

                statement.executeUpdate(query);
            }

//            try (Statement stmt = connection.createStatement()) {
//                String query = "INSERT INTO `users` (`username`, `password`)" +
//                        "VALUES ('Ivan', '123'), ('Gosho', 'abc')";
//
//                stmt.executeUpdate(query);
//            }

            if (login(connection, "Ivan", "123")) {
                System.out.println("Ivan logged in successfully!");
            } else {
                System.out.println("Failed to log in.");
            }

            if (login(connection, "Gosho", "123")) {
                System.out.println("Gosho logged in successfully!");
            } else {
                System.out.println("Failed to log in.");
            }
        }
    }

    private static boolean login(Connection connection, String user, String password) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT COUNT(id)" +
                    "FROM users " +
                    "WHERE username='" + user + "' AND password='" + password + "'";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            int usersCount = rs.getInt(1);

            return usersCount > 0;
        }
    }

    private static boolean loginPrepared(Connection connection, String user, String password) throws SQLException {
        String query = "SELECT COUNT(id)" +
                "FROM users " +
                "WHERE username=? AND password=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int usersCount = rs.getInt(1);

            return usersCount > 0;
        }
    }
}
