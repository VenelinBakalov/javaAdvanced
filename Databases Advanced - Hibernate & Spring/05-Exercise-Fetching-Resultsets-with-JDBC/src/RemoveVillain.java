import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class RemoveVillain {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(reader.readLine());

        String deleteFromMapTableQuery = "DELETE FROM villains_minions WHERE villain_id = ?;";
        String deleteFromVillainTableQuery = "DELETE FROM villains WHERE villain_id = ?;";
        String selectVillain = "SELECT * FROM villains WHERE villain_id = ?;";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillain);
            selectVillainStatement.setInt(1, villainId);
            ResultSet villainResult = selectVillainStatement.executeQuery();

            if (! villainResult.next()) {
                System.out.println("No such villain was found.");
                selectVillainStatement.close();
                return;
            }

            PreparedStatement deleteFromMapStatement = connection.prepareStatement(deleteFromMapTableQuery);
            deleteFromMapStatement.setInt(1, villainId);
            int minionsReleased = deleteFromMapStatement.executeUpdate();
            deleteFromMapStatement.close();

            String villainName = villainResult.getString("name");
            selectVillainStatement.close();

            PreparedStatement deleteVillainStatement = connection.prepareStatement(deleteFromVillainTableQuery);
            deleteVillainStatement.setInt(1, villainId);
            deleteVillainStatement.executeUpdate();
            deleteVillainStatement.close();

            System.out.println(villainName + " was deleted.");
            System.out.println(minionsReleased + " minions released.");

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
