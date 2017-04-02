package exercise.database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Venelin on 2.4.2017 г..
 */
public class DatabaseImplTests {

    private static final Integer[] INITIAL_VALUES_MORE_THAN_MAX = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
    private static final Integer[] INITIAL_VALUES = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    private static final Integer[] GET_ELEMENTS_EXPECTED_VALUES = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    private static final int ADD_TEST_VALUE = 15;
    private static final Integer[] ADD_TEST_EXPECTED_VALUES = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    private static final Integer[] INITIAL_ONE_ELEMENT_TEST_REMOVE = {1};


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

    @Test
    public void testGetElementsAfterCorrectSetInConstructor() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES);
        Assert.assertArrayEquals("Incorrect get elements method", GET_ELEMENTS_EXPECTED_VALUES, db.getElements());
    }

    @Test
    public void testAddWithCorrectInput() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_VALUES);
        db.add(ADD_TEST_VALUE);
        Assert.assertArrayEquals("Incorrect add method", ADD_TEST_EXPECTED_VALUES, db.getElements());
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_ONE_ELEMENT_TEST_REMOVE);
        db.add(ADD_TEST_VALUE);
        db.remove();
        Assert.assertEquals("Remove does not work correctly", 1, db.getElements().length);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveElementWithNoElements() throws OperationNotSupportedException {
        Database<Integer> db = new DatabaseImpl<>(INITIAL_ONE_ELEMENT_TEST_REMOVE);
        db.remove();
        db.getElements();
    }
}

