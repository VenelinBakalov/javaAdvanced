import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by Venelin on 12.7.2017 г..
 */
public class AddMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minionArgs = reader.readLine().split("\\s+");
        String minionName = minionArgs[1];
        int age = Integer.parseInt(minionArgs[2]);
        String townName = minionArgs[3];

        String[] villainArgs = reader.readLine().split("\\s+");
        String villainName = villainArgs[1];

        String selectTownQuery = "SELECT * FROM towns WHERE name = ?;";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ?;";
        String selectMinionQuery = "SELECT * FROM minions WHERE name = ?;";

        String insertTownQuery = "INSERT INTO towns(name) VALUES (?);";
        String insertVillainQuery = "INSERT INTO villains (name, evilness_factor) VALUES (?, 'evil');";

        String insertMinionQuery = "INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?);";
        String insertVillainMinionRelationQuery = "INSERT INTO villains_minions(villain_id, minion_id) VALUES (?, ?);";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();

            if (!townResult.next()) {
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1, townName);
                insertTownStatement.executeUpdate();
                System.out.println(String.format("Town %s was added to the database.", townName));
                insertTownStatement.close();
            }

            int townId = 0;
            ResultSet townResultUpdated = townStatement.executeQuery();

            if (townResultUpdated.next()) {
                townId = townResultUpdated.getInt("town_id");
            }
            townStatement.close();

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1, villainName);
            ResultSet villainResult = selectVillainStatement.executeQuery();

            if (!villainResult.next()) {
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                insertVillainStatement.close();
                System.out.println(String.format("Villain %s was added to the database.", villainName));
            }

            int villainId = 0;
            ResultSet villainResultUpdated = selectVillainStatement.executeQuery();
            if (villainResultUpdated.next()) {
                villainId = villainResultUpdated.getInt("villain_id");
            }
            selectVillainStatement.close();

            PreparedStatement insertMinionStatement = connection.prepareStatement(insertMinionQuery);
            insertMinionStatement.setString(1, minionName);
            insertMinionStatement.setInt(2, age);
            insertMinionStatement.setInt(3, townId);
            insertMinionStatement.executeUpdate();
            insertMinionStatement.close();
//                System.out.println(String.format("Minion %s was added to the database.", minionName));

            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinionQuery);
            selectMinionStatement.setString(1, minionName);

            ResultSet minionResult = selectMinionStatement.executeQuery();
            int minionId = 0;
            if (minionResult.next()) {
                minionId = minionResult.getInt("minion_id");
            }
            selectMinionStatement.close();

            PreparedStatement insertMappingTableStatement = connection.prepareStatement(insertVillainMinionRelationQuery);
            insertMappingTableStatement.setInt(1, villainId);
            insertMappingTableStatement.setInt(2, minionId);
            insertMappingTableStatement.executeUpdate();
            System.out.println(String.format("Successfully added %s to be minion of %s", minionName, villainName));
            insertMappingTableStatement.close();

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
