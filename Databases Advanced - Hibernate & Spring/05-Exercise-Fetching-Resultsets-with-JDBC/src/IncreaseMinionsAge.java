import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.stream.Stream;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class IncreaseMinionsAge {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] minionsIds = Stream.of(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String updateMinionsQuery = "UPDATE minions " +
                "SET age = age + 1, name = CONCAT(UPPER(LEFT(name, 1)), SUBSTRING(name, 2)) " +
                "WHERE minion_id IN ( ";

        for (int i = 0; i < minionsIds.length; i++) {
            updateMinionsQuery += "?, ";
        }
        updateMinionsQuery = updateMinionsQuery.substring(0, updateMinionsQuery.length() - 2) + ");";

        String getAllMinionsQuery = "SELECT name, age FROM minions;";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement updateMinionsStatement = connection.prepareStatement(updateMinionsQuery);
                Statement getAllMinionsStatement = connection.createStatement()
                ){
            int parameterIndex = 0;

            for (int minionsId : minionsIds) {
                updateMinionsStatement.setInt(++parameterIndex, minionsId);
            }

            updateMinionsStatement.executeUpdate();

            ResultSet minions = getAllMinionsStatement.executeQuery(getAllMinionsQuery);

            while (minions.next()) {
                System.out.println(String.format("%s %d", minions.getString("name"), minions.getInt("age")));
            }
        }
    }
}
