package app.service.impl;

import app.dao.api.BookDao;
import app.model.Book;
import app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Service
@Transactional
public class BookServiceImpl implements BookService<Book, Long> {

    @Autowired
    private BookDao dao;

    @Override
    public Book findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Book object) {
        dao.delete(object);
    }

    @Override
    public List<Book> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Book object) {
        dao.save(object);
    }

    @Override
    public List<String> findAllBookTitlesAfter2000Year() {
        return dao.findAllBookTitlesAfter2000Year();
    }

    @Override
    public List<Book> findAllByGeorgePowell() {
        return dao.findAllByGeorgePowell();
    }
}
