package entityManager;

import connection.ConnectionManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Venelin on 11.7.2017 г..
 */
public class EntityManager implements DBContext {

    private Connection connection;

    public EntityManager() throws SQLException {
        this.connection = ConnectionManager.getConnection();
    }

    @Override
    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException, NoSuchFieldException {
        String tableName = entity.getClass().getSimpleName().toLowerCase();
        createTableIfNotExistent(entity, tableName);

        Field primaryKey = entity.getClass().getDeclaredField("id");
        Object value = primaryKey.get(entity);

        if (value == null || (Integer) value <= 0) {
            insert(entity, primaryKey);
        } else {
            update(entity, primaryKey);
        }

        return true;
    }

    //TODO IMPLEMENT THESE 2 METHODS!!!
    private <E> void update(E entity, Field primaryKey) {
    }

    private <E> void insert(E entity, Field primaryKey) {
    }

    private <E> boolean createTableIfNotExistent(E entity, String tableName) throws IllegalAccessException, SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY,";

        Field[] fields = entity.getClass().getDeclaredFields();
        String columns = "";

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String fieldName = field.getName();

            if ("id".equals(fieldName)) continue;

            columns += fieldName + " " + typeMapper(field, entity);

            if (i < fields.length - 1) {
                columns += ",";
            }
        }

        createTableQuery += columns + ")";

        try (PreparedStatement statement = connection.prepareStatement(createTableQuery)) {
            return statement.execute();
        }
    }

    private String typeMapper(Field field, Object entity) throws IllegalAccessException {
        Object value = field.get(entity);
        if (value instanceof Integer) {
            return "INT";
        }

        if (value instanceof String) {
            return "VARCHAR(20)";
        }

        if (value instanceof LocalDate) {
            return "DATE";
        }

        return null;
    }

    @Override
    public void closeConnection() {

    }
}
