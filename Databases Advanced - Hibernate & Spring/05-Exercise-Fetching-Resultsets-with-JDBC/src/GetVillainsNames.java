import java.sql.*;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class GetVillainsNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException {
        String getVillainsQuery = "SELECT v.name, COUNT(*) AS minion_count " +
                "FROM villains AS v " +
                "INNER JOIN villains_minions AS vm ON v.villain_id = vm.villain_id " +
                "GROUP BY v.name " +
                "HAVING minion_count > 3 " +
                "ORDER BY minion_count DESC;";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ){
            ResultSet resultSet = statement.executeQuery(getVillainsQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int minionCount = resultSet.getInt("minion_count");
                System.out.println(name + " " + minionCount);
            }
        }
    }
}
