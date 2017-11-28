package exercise.database;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Venelin on 2.4.2017 г..
 */
public interface Database<T extends Integer> {

    void add(T element) throws OperationNotSupportedException;

    void remove() throws OperationNotSupportedException;

    T[] getElements();
}
