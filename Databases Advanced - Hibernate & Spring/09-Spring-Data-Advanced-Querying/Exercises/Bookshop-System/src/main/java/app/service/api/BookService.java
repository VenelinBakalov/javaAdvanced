package app.service.api;

import app.model.AgeRestriction;
import app.model.ReducedBook;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
public interface BookService<Book, Long> extends ServiceInterface<Book, Long> {

    List<String> findAllBookTitlesAfter2000Year();
    List<app.model.Book> findAllByGeorgePowell();

    List<app.model.Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    Integer findBookCountByTitleLength(int length);
    List<String> findAllGoldenEditionAndLessThan5000Copies();
    List<String> findBooksWithPriceLessThan5GreaterThan40();
    List<String> findBooksNotReleaseOn(int year);
    List<String> findBookTitlesByCategories(List<String> categories);
    List<app.model.Book> findBooksReleasedBefore(Date date);
    List<String> findAllWhoseTitleContains(String pattern);
    List<app.model.Book> findBooksWithTitlesWrittenByLastNameEndingWith(String pattern);
    Integer updateBookCopiesAfterDate(Date date, int copies);
    Integer removeBooksWithLessCopiesThan(int minCopies);

    ReducedBook findReducedBookByTitle(String title);

}
