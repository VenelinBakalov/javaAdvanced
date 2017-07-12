import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class PrintAllMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException {
        String getMinionNamesQuery = "SELECT name FROM minions;";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ){
            List<String> minionNames = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery(getMinionNamesQuery);
            while (resultSet.next()) {
                minionNames.add(resultSet.getString("name"));
            }

            for (int i = 0; i < minionNames.size() / 2; i++) {
                System.out.println(minionNames.get(i));
                System.out.println(minionNames.get(minionNames.size() - i - 1));
            }
        }
    }
}
