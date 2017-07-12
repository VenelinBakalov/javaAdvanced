import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public class InitialSetup {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String createQuery = "CREATE DATABASE minions_db;";
        String useQuery = "USE minions_db";

        String createTownsTableQuery = "CREATE TABLE towns(" +
                "town_id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(20)," +
                "country VARCHAR(20));";

        String createMinionsTableQuery = "CREATE TABLE minions(" +
                "minion_id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "age INT," +
                "town_id INT," +
                "CONSTRAINT fk_towns_minions FOREIGN KEY (town_id) REFERENCES towns (town_id));";

        String createVillainsTableQuery = "CREATE TABLE villains(" +
                "villain_id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "evilness_factor VARCHAR(50));";

        String createVillainsMinionsTableQuery = "CREATE TABLE villains_minions(" +
                "villain_id INT," +
                "minion_id INT," +
                "CONSTRAINT pk_villains_minions PRIMARY KEY (villain_id, minion_id)," +
                "CONSTRAINT fk_villains_minions_villains FOREIGN KEY (villain_id) REFERENCES villains(villain_id)," +
                "CONSTRAINT fk_villains_minions_minions FOREIGN KEY (minion_id) REFERENCES minions(minion_id));";

        String insertTowns = "INSERT INTO towns (name, country)" +
                "VALUES ('Sofia', 'Bulgaria'), ('Venice', 'Italy'), ('New York', 'USA'), ('Pernik', 'Bulgaria'), ('Mordor', 'Middle Earth');";
        String insertMinions = "INSERT INTO minions(name, age, town_id)" +
                "VALUES ('Bob', 22, 2), ('Gosho', 15, 4), ('LardaX', 27, 1), ('Edd', 17, 3), ('Saruman', 20, 5);";
        String insertVillains = "INSERT INTO villains (name, evilness_factor)" +
                "VALUES ('Sauron', 'super evil'), ('Grue', 'good'), ('Java', 'Good'), ('C#', 'super evil'), ('Dinko', 'Bad');";
        String insertRelations = "INSERT INTO villains_minions " +
                "VALUES (2,1), (3,5), (4,2), (1,3), (2,2), (5,1), (2, 3), (2, 4), (2, 5), (1, 1), (1, 5), (1, 4)";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
                ){

            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownsTableQuery);
            statement.executeUpdate(createMinionsTableQuery);
            statement.executeUpdate(createVillainsTableQuery);
            statement.executeUpdate(createVillainsMinionsTableQuery);

            statement.executeUpdate(insertTowns);
            statement.executeUpdate(insertMinions);
            statement.executeUpdate(insertVillains);
            statement.executeUpdate(insertRelations);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
