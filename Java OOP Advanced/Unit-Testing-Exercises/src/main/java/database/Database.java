package database;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

/**
 * Created by Venelin on 31.3.2017 г..
 */
public class Database {
    private static final int CAPACITY = 16;

    private Integer[] data;
    private int index;

    public Database(Integer... data) throws OperationNotSupportedException {
        this.setData(data);
        this.index = data.length;
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }
        if (this.index >= CAPACITY) {
            throw new OperationNotSupportedException("DatabaseImpl cannot store more than 16 elements");
        }
        this.data[index++] = element;
    }

    // assert [0] = null

    public Integer remove() throws OperationNotSupportedException {
        if (this.index == 0) {
            throw new OperationNotSupportedException();
        }
        Integer lastElement = this.data[--this.index];
        this.data[this.index] = null;
        return lastElement;
    }

    public Integer[] fetch() {
        Integer[] elements = Arrays.stream(this.data).limit(index).toArray(Integer[]::new);
        return elements;
    }

    private void setData(Integer... data) throws OperationNotSupportedException {
        if (data.length > CAPACITY) {
            throw new OperationNotSupportedException("DatabaseImpl cannot store more than 16 elements");
        }

        for (Integer integer : data) {
            if (integer == null) {
                throw new OperationNotSupportedException();
            }
        }
        this.data = Arrays.copyOf(data, CAPACITY);
    }
}
