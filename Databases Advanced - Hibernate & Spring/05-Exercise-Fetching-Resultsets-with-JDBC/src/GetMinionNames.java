import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class GetMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(reader.readLine());
        String villainName;

        String getVillainNameQuery = "SELECT v.name FROM villains AS v WHERE v.villain_id = ?";

        String getMinionsQuery = "SELECT m.name, m.age " +
                "FROM minions AS m " +
                "INNER JOIN villains_minions AS vm ON m.minion_id=vm.minion_id " +
                "WHERE vm.villain_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

            try (PreparedStatement statement = connection.prepareStatement(getVillainNameQuery)){
                statement.setInt(1, villainId);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                villainName = resultSet.getString("name");
                System.out.println("Villain: " + villainName);
            } catch (SQLException e) {
                System.out.println("No villain with ID " + villainId + " exists in the database.");
                return;
            }

            try (PreparedStatement statement = connection.prepareStatement(getMinionsQuery)){
                statement.setInt(1, villainId);
                ResultSet resultSet = statement.executeQuery();

                int minionIndex = 0;
                while (resultSet.next()) {
                    String minionName = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println(String.format("%d. %s %d", ++minionIndex, minionName, age));
                }

                if (minionIndex == 0) {
                    System.out.println("<no minions>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
