package app.service.api;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
public interface BookService<Book, Long> extends ServiceInterface<Book, Long> {

    List<String> findAllBookTitlesAfter2000Year();
    List<app.model.Book> findAllByGeorgePowell();

}
