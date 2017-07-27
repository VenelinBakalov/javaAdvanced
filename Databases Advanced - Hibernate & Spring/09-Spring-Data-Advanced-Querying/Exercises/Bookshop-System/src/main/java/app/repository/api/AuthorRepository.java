package app.repository.api;

import app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author AS a inner join a.books AS b WHERE YEAR(b.releaseDate) < 1990")
    List<Author> findAuthorsWithBookReleasedBefore1990();

    @Query("select a.firstName, a.lastName, count(*) as book_count from Author as a inner join a.books " +
            "group by a.firstName, a.lastName order by book_count desc")
    List<Object[]> findAllOrderedByBookCount();

    List<Author> findAllByFirstNameEndsWith(String pattern);

    @Query("select concat(a.firstName, ' ', a.lastName), sum(b.copies) from Author as a inner join a.books as b " +
            "group by a.firstName, a.lastName order by sum(b.copies) desc ")
    List<Object[]> findTotalBookCopiesCountByAuthor();
}
