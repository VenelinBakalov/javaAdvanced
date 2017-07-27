package app.service.impl;

import app.model.AgeRestriction;
import app.model.Book;
import app.model.ReducedBook;
import app.repository.api.BookRepository;
import app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public Integer removeBooksWithLessCopiesThan(int minCopies) {
        return this.bookRepository.removeBooksWithLessCopiesThan(minCopies);
    }

    @Override
    public ReducedBook findReducedBookByTitle(String title) {
        return this.bookRepository.findReducedBookByTitle(title);
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

    @Override
    public List<String> findBookTitlesByCategories(@Param("categories") List<String> categories) {
        return this.bookRepository.findBookTitlesByCategories(categories, categories.size());
    }

    @Override
    public List<Book> findBooksReleasedBefore(Date date) {
        return this.bookRepository.findBooksReleasedBefore(date);
    }

    @Override
    public List<String> findAllWhoseTitleContains(String pattern) {
        return this.bookRepository.findAllWhoseTitleContains(pattern);
    }

    @Override
    public List<Book> findBooksWithTitlesWrittenByLastNameEndingWith(String pattern) {
        return this.bookRepository.findBooksWithTitlesWrittenByLastNameEndingWith(pattern);
    }
}
