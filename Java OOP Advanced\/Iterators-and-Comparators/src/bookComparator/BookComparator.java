package bookComparator;

import java.util.Comparator;

/**
 * Created by Venelin on 22.3.2017 г..
 */
public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        if (firstBook.getTitle().compareTo(secondBook.getTitle()) == 0) {
            if (firstBook.getYear() > secondBook.getYear()) {
                return 1;
            } else if (firstBook.getYear() < secondBook.getYear()) {
                return -1;
            }
            return 0;
        } else {
            return firstBook.getTitle().compareTo(secondBook.getTitle());
        }
    }
}
