package app.service.impl;

import app.repository.api.BookRepository;
import app.model.AgeRestriction;
import app.model.Book;
import app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Service
@Transactional
public class BookServiceImpl implements BookService<Book, Long> {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void remove(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book object) {
        bookRepository.save(object);
    }

    @Override
    public List<String> findAllBookTitlesAfter2000Year() {
        return bookRepository.findAllBookTitlesAfter2000Year();
    }

    @Override
    public List<Book> findAllByGeorgePowell() {
        return bookRepository.findAllByGeorgePowell();
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestrictionQuery(ageRestriction);
    }

    @Override
    public Integer findBookCountByTitleLength(int length) {
        return this.bookRepository.findBookCountByTitleLength(length);
    }

    @Override
    public Integer updateBookCopiesAfterDate(Date date, int copies) {
        return this.bookRepository.updateBookCopiesAfterDate(date, copies);
    }

    @Override
    public List<String> findAllGoldenEditionAndLessThan5000Copies() {
        return this.bookRepository.findAllGoldenEditionAndLessThan5000Copies();
    }

    @Override
    public List<String> findBooksWithPriceLessThan5GreaterThan40() {
        return this.bookRepository.findBooksWithPriceLessThan5GreaterThan40();
    }

    @Override
    public List<String> findBooksNotReleaseOn(int year) {
        return this.bookRepository.findBooksNotReleaseOn(year);
    }
}
