package app.service.impl;

import app.dao.api.AuthorDao;
import app.model.Author;
import app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService<Author, Long> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author findById(Long id) {
        return authorDao.findOne(id);
    }

    @Override
    public void remove(Author object) {
        authorDao.delete(object);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public void save(Author object) {
        authorDao.save(object);
    }

    @Override
    public List<Author> findAuthorsWithBookReleasedBefore1990() {
        return authorDao.findAuthorsWithBookReleasedBefore1990();
    }

    @Override
    public List<Object[]> findAllOrderedByBookCount() {
        return authorDao.findAllOrderedByBookCount();
    }
}
