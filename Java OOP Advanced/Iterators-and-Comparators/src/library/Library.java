package library;

import java.util.Iterator;

/**
 * Created by Venelin on 21.3.2017 г..
 */
public class Library<Book> implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return books.length > counter;
        }

        @Override
        public Book next() {
            counter++;
            return books[counter - 1];
        }
    }
}
