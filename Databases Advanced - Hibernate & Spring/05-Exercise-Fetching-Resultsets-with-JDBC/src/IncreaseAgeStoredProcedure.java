import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class IncreaseAgeStoredProcedure {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minionId = Integer.parseInt(reader.readLine());

        String procedure = "CALL usp_get_older (?);";
        String getMinionQuery = "SELECT name, age FROM minions WHERE minion_id = ?;";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            CallableStatement callableStatement = connection.prepareCall(procedure);
            callableStatement.setInt(1, minionId);
            callableStatement.execute();
            callableStatement.close();

            PreparedStatement preparedStatement = connection.prepareStatement(getMinionQuery);
            preparedStatement.setInt(1, minionId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println(String.format("%s %d", resultSet.getString("name"), resultSet.getInt("age")));
            }
            preparedStatement.close();
        }
    }

    /*
    DELIMITER $$

CREATE PROCEDURE usp_get_older(minion_id INT)
BEGIN
	UPDATE minions AS m
	SET age = age + 1
	WHERE m.minion_id = minion_id;
END $$

DELIMITER ;
     */
}
