package entityManager;

import connection.ConnectionManager;
import persistence.Entity;
import persistence.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

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
        createTableIfNotExistent(entity);

        Field primaryKey = entity.getClass().getDeclaredField("id");
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);

        if (value == null || (Long) value <= 0) {
            insert(entity, primaryKey);
        } else {
            update(entity, primaryKey);
        }


        return true;
    }

    private <E> void update(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = tableName(entity);
        String updateQuery = "UPDATE " + tableName + " SET ";
        String where = " WHERE ";

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            String columnName = columnName(field);
            Object columnValue = field.get(entity);


            if (isPrimaryKey(field)) {
                where += columnName + " = " + "'" + columnValue + "'" + ";";
                continue;
            }

            updateQuery += columnName + " = '" + columnValue + "'";

            if (i < fields.length - 1) {
                updateQuery += ", ";
            }
        }

        updateQuery += where;

        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.execute();
        }
    }

    private <E> void insert(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = tableName(entity);
        String insertQuery = "INSERT INTO " + tableName + " (";

        String columns = "";
        String values = "";

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (isPrimaryKey(field)) continue;

            columns += columnName(field);

            Object value = field.get(entity);

            values += "'" + value + "'";

            if (i < fields.length - 1) {
                columns += ", ";
                values += ", ";
            }
        }

        insertQuery += columns + ") VALUES (" + values + ")";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.execute();
        }

        updateEntityPrimaryKey(entity, primaryKey, tableName);

    }

    private <E> void updateEntityPrimaryKey(E entity, Field primaryKey, String tableName) throws IllegalAccessException, SQLException {
        Field field = entity.getClass().getDeclaredFields()[1];
        field.setAccessible(true);
        String columnName = columnName(field);
        Object columnValue = field.get(entity);

        String selectIdQuery = "SELECT id FROM " + tableName + " WHERE " + columnName + " = '" + columnValue + "';";

        try (PreparedStatement statement = connection.prepareStatement(selectIdQuery)) {
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong("id");

            primaryKey.set(entity, id);
        }
    }

    private <E> boolean createTableIfNotExistent(E entity) throws IllegalAccessException, SQLException {
        checkPrimaryKey(entity);

        String tableName = tableName(entity);

        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
        Field[] fields = entity.getClass().getDeclaredFields();
        String columns = "";

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String columnName = columnName(field);

            if (isPrimaryKey(field)) {
                columns += columnName + " " + typeMapper(field, entity) + "AUTO_INCREMENT PRIMARY KEY";
            } else {
                columns += columnName + " " + typeMapper(field, entity);
            }

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

        if (value instanceof Long) {
            return "BIGINT";
        }

        if (value instanceof String) {
            return "VARCHAR(20)";
        }

        if (value instanceof LocalDate) {
            return "DATE";
        }

        return null;
    }

    private <E> String tableName(E entity) {
        String tableName = "";
        Entity entityAnnotation = entity.getClass().getAnnotation(Entity.class);

        if (entityAnnotation != null) {
            tableName = entityAnnotation.name();
        }

        if (tableName.isEmpty()) {
            tableName = entity.getClass().getSimpleName().toLowerCase();
        }

        return tableName;
    }

    private String columnName(Field field) {
        String columnName = "";
        Entity entityAnnotation = field.getAnnotation(Entity.class);

        if (entityAnnotation != null) {
            columnName = entityAnnotation.name();
        }

        if (columnName.isEmpty()) {
            columnName = field.getName();
        }

        return columnName;
    }

    private boolean isPrimaryKey(Field field) {
        return field.isAnnotationPresent(Id.class);
    }

    private <E> void checkPrimaryKey(E entity) {
        long idAnnotationsCount = Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .count();

        if (idAnnotationsCount != 1) throw new IllegalStateException("Entity should have single primary key field.");
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            // log here
        }
    }
}
