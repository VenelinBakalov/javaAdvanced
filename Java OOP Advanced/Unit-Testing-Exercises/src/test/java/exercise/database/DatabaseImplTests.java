package exercise.database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Venelin on 2.4.2017 г..
 */
public class DatabaseImplTests {

    private static final Integer[] INITIAL_VALUES_MORE_THAN_MAX = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
    private static final Integer[] INITIAL_VALUES = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};


    @Test(expected = OperationNotSupportedException.class)
    public void testInitializeDatabaseWithZeroLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testInitializeDatabaseWithThanMaxLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES_MORE_THAN_MAX);
    }

    @Test
    public void testInitializeDatabaseWithCorrectValuesLength() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES);
    }
}
