package app.repository.api;

import app.model.AgeRestriction;
import app.model.Book;
import app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Those two are from previous exercise
    @Query("SELECT b.title FROM Book AS b WHERE YEAR(b.releaseDate) > 2000")
    List<String> findAllBookTitlesAfter2000Year();

    @Query("SELECT b FROM Book AS b WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "order by b.releaseDate desc, b.title asc ")
    List<Book> findAllByGeorgePowell();

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b from Book as b where b.ageRestriction = :ageRestriction")
    List<Book> findAllByAgeRestrictionQuery(@Param("ageRestriction") AgeRestriction ageRestriction);

    @Query("SELECT COUNT(b) FROM Book as b where length(b.title) > :length")
    Integer findBookCountByTitleLength(@Param("length") int length);

    @Query("UPDATE Book AS b set b.copies = b.copies + :copies where b.releaseDate > :date")
    @Modifying
    Integer updateBookCopiesAfterDate(@Param("date") Date date, @Param("copies") int copies);

    @Query("select b.title from Book as b where b.editionType = 'GOLD' and b.copies < 5000")
    List<String> findAllGoldenEditionAndLessThan5000Copies();

    @Query("select concat(b.title, '- $', b.price) from Book as b where b.price < 5 OR b.price > 40")
    List<String> findBooksWithPriceLessThan5GreaterThan40();

    @Query("select b.title from Book as b where year(b.releaseDate) != :year")
    List<String> findBooksNotReleaseOn(@Param("year") int year);

    @Query("select b.title from Book as b where b.categories = :categories")
    List<String> findBookTitlesByCategories(@Param("categories") Set<Category> categories);

    @Query("select b from Book as b where b.releaseDate < :date")
    List<Book> findBooksReleasedBefore(@Param("date") Date date);
}
