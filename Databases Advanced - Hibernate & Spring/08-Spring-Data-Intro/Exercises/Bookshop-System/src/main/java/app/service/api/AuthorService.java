package app.service.api;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
public interface AuthorService<Author, Long> extends ServiceInterface<Author, Long> {

    List<Author> findAuthorsWithBookReleasedBefore1990();

    List<Object[]> findAllOrderedByBookCount();

}
