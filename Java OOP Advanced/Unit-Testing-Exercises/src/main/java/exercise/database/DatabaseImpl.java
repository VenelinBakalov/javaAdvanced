package exercise.database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Venelin on 2.4.2017 г..
 */
public class DatabaseImpl<T extends Integer> implements Database<T> {

    private static final int INITIAL_CAPACITY = 16;
    private T[] elements;
    private int elementsCount = 0;
    private int index;

    public DatabaseImpl(T... elements) throws OperationNotSupportedException {
        this.elementsCount = elements.length;
        this.setElements(elements);
        this.index = elementsCount - 1;
    }

    public void add(T element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++index] = element;
        this.elementsCount++;
    }

    public void remove() throws OperationNotSupportedException {
        try {
            this.elements[index--] = null;
            this.elementsCount--;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new OperationNotSupportedException();
        }
    }

    public T[] getElements() {
        T[] buffer = (T[]) Array.newInstance(this.elements[0].getClass(), this.elementsCount);;
        int bufferIndex = 0;

        for (T element : elements) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }

        return buffer;
    }

    private void setElements(T... elements) throws OperationNotSupportedException {
        if (elements.length > 16 || elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = (T[]) Array.newInstance(elements[0].getClass(), INITIAL_CAPACITY);

        int bufferIndex = 0;

        for (T element : elements) {
            this.elements[bufferIndex++] = element;
        }
        
        this.index = elements.length - 1;
    }

}
