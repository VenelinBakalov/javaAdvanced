package bookLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Library {

    private String name;
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(String name) {
        this();
        this.setName(name);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
