package app.service.api;

import app.model.AgeRestriction;
import app.model.Category;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    List<String> findBookTitlesByCategories(Set<Category> categories);
    List<app.model.Book> findBooksReleasedBefore(Date date);

    Integer updateBookCopiesAfterDate(Date date, int copies);

}
