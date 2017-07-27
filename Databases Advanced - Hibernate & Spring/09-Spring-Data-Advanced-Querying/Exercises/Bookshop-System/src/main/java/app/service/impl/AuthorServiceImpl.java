package app.service.impl;

import app.repository.api.AuthorRepository;
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
    private AuthorRepository authorRepository;

    @Override
    public Author findById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public void remove(Author object) {
        authorRepository.delete(object);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(Author object) {
        authorRepository.save(object);
    }

    @Override
    public List<Author> findAuthorsWithBookReleasedBefore1990() {
        return authorRepository.findAuthorsWithBookReleasedBefore1990();
    }

    @Override
    public List<Object[]> findAllOrderedByBookCount() {
        return authorRepository.findAllOrderedByBookCount();
    }

    @Override
    public List<Author> findAllByFirstNameEndsWith(String pattern) {
        return authorRepository.findAllByFirstNameEndsWith(pattern);
    }

    @Override
    public List<Object[]> findTotalBookCopiesCountByAuthor() {
        return this.authorRepository.findTotalBookCopiesCountByAuthor();
    }
}
