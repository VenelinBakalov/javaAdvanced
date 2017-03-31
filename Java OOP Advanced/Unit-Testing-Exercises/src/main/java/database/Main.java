package database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

/**
 * Created by Venelin on 1.4.2017 г..
 */
public class Main {

    public static void main(String[] args) throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database database = new Database();
        database.add(15);
        Field field = Database.class.getDeclaredField("data");
        field.setAccessible(true);
        Integer[] ints = (Integer[]) field.get(database);
        System.out.println(ints[0]);
        database.add(null);
    }
}
