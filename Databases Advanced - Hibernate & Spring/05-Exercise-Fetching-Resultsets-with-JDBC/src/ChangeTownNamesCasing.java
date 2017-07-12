import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class ChangeTownNamesCasing {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();

        String updateTownsQuery = "UPDATE towns " +
                "SET name = UPPER(name) " +
                "WHERE country = ?;";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(updateTownsQuery)
                ){
            statement.setString(1, country);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No town names were affected.");
            } else {
                System.out.println(rowsAffected + " town names were affected.");

                String getTownNamesQuery = "SELECT name FROM towns WHERE country = ?";
                PreparedStatement getTownsStatement = connection.prepareStatement(getTownNamesQuery);
                getTownsStatement.setString(1, country);
                ResultSet townsResult = getTownsStatement.executeQuery();

                List<String> townNames = new ArrayList<>();
                while (townsResult.next()) {
                    townNames.add(townsResult.getString("name"));
                }

                System.out.println(String.format("[%s]", String.join(", ", townNames)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
