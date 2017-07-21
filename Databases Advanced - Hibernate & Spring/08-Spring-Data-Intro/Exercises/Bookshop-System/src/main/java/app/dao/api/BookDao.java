package app.dao.api;

import app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Repository
public interface BookDao extends JpaRepository<Book, Long> {

    @Query("SELECT b.title FROM Book AS b WHERE YEAR(b.releaseDate) > 2000")
    List<String> findAllBookTitlesAfter2000Year();

    @Query("SELECT b FROM Book AS b WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "order by b.releaseDate desc, b.title asc ")
    List<Book> findAllByGeorgePowell();
}
