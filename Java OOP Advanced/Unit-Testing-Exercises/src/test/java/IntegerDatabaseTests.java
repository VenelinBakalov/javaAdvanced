import database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;
import java.lang.reflect.Field;

/**
 * Created by Venelin on 1.4.2017 г..
 */
public class IntegerDatabaseTests {

    private static final int TEST_ELEMENT = 1;
    private static final String DATA_FIELD_NAME = "data";
    private static final int DATABASE_CAPACITY = 16;
    private static final int SECOND_TEST_ELEMENT = 2;
    private static final int FIRST_FREE_POSITION = 1;
    public static final int FIRST_ELEMENT_INDEX = 0;

    private Database database;
    private Integer[] data;
    private Field dataField;

    @Before
    public void initializeDatabase() throws OperationNotSupportedException, ReflectiveOperationException {
        this.database = new Database(TEST_ELEMENT);

        this.dataField = Database.class.getDeclaredField(DATA_FIELD_NAME);
        this.dataField.setAccessible(true);
        this.data = (Integer[]) this.dataField.get(this.database);
    }

    // Testing capacity
    @Test
    public void databaseCapacityShouldBeEqualToCapacityConstant() throws ReflectiveOperationException {
        Assert.assertEquals(DATABASE_CAPACITY, this.data.length);
    }

    // Testing constructors
    @Test
    public void instantiatingDatabaseWithEmptyConstructorShouldNotThrowException() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test
    public void allValuesInAnEmptyDatabaseShouldBeNull() throws OperationNotSupportedException, IllegalAccessException {
        Database db = new Database();
        Integer[] emptyData = (Integer[]) this.dataField.get(db);
        for (int i = 0; i < DATABASE_CAPACITY; i++) {
            if (emptyData[i] != null) {
                throw new IllegalStateException("Value should be null");
            }
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void passingMoreThanCapacitySizeArgumentsToConstructorShouldThrowException() throws OperationNotSupportedException {
        Integer[] testArray = new Integer[DATABASE_CAPACITY + 1];
        Database db = new Database(testArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void passingNullValueInConstructorShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(TEST_ELEMENT, null, TEST_ELEMENT);
    }

    // Testing element adding
    @Test
    public void addingElementShouldStoreItAtFirstFreePosition() throws OperationNotSupportedException, ReflectiveOperationException {
        this.database.add(SECOND_TEST_ELEMENT);
        int secondElement = this.data[FIRST_FREE_POSITION];
        Assert.assertEquals(SECOND_TEST_ELEMENT, secondElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullObjectShouldThrowException() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingMoreElementsThanCapacityShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < DATABASE_CAPACITY; i++) {
            this.database.add(TEST_ELEMENT);
        }
    }

    // Testing element removal
    @Test
    public void removeOperationShouldRemoveLastAddedElement() throws OperationNotSupportedException {
        this.database.add(SECOND_TEST_ELEMENT);
        this.database.add(TEST_ELEMENT);
        int removedElement = this.database.remove();
        Assert.assertEquals(TEST_ELEMENT, removedElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingElementFromEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
    }

    // Testing elements fetch
    @Test
    public void fetchMethodShouldReturnArrayWithAllElements() throws OperationNotSupportedException {
        this.database.add(SECOND_TEST_ELEMENT);
        Integer[] fetchedElements = this.database.fetch();
        int firstElement = fetchedElements[FIRST_ELEMENT_INDEX];
        int secondElement = fetchedElements[FIRST_FREE_POSITION];
        Assert.assertEquals(TEST_ELEMENT, firstElement);
        Assert.assertEquals(SECOND_TEST_ELEMENT, secondElement);
    }
}
